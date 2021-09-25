package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.app.beans.Project;

public class ProjectDaoImpl implements ProjectDao {

	private static Connection conn;
	static {
		conn = DBUtil.getMyConnection();
	}

	public int generateId() {
		PreparedStatement getIdsStatement;
		int id = 0;
		try {
			getIdsStatement = conn.prepareStatement("Select projid from Project");
			ResultSet rs = getIdsStatement.executeQuery();
			while (rs.next()) {
				if (id < rs.getInt(1))
					id = rs.getInt(1);
			}
			id = id + 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public String getUserName(int id) {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select name from User where userid=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String name = rs.getString(1);
			System.out.println("Name is: " + name);
			return name;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void createProject(Project p, List<Integer> team) {
		PreparedStatement addToProjectStatement, addToTeamStatement;
		String teamMembers = "";
		try {
			addToTeamStatement = conn.prepareStatement("insert into team values(?,?)");
			addToProjectStatement = conn.prepareStatement("insert into project values(?,?,?,?,?,?)");
			int id = generateId();
			addToProjectStatement.setInt(1, id);
			addToProjectStatement.setString(2, p.getName());
			addToProjectStatement.setString(3, p.getDescription());
			addToProjectStatement.setDate(4, Date.valueOf(p.getStartDate()));
			addToProjectStatement.setString(5, p.getStatus());
			teamMembers = p.getTeamMembers().stream().map(Object::toString).collect(Collectors.joining(", "));
			addToProjectStatement.setString(6, teamMembers);
			int num = addToProjectStatement.executeUpdate();
			if (num > 0) {
				addToTeamStatement.setInt(2, id);
				for (int userId : team) {
					addToTeamStatement.setInt(1, userId);
					int num1 = addToTeamStatement.executeUpdate();
					if (num1 < 1) {
						break;
					}
				}
				conn.commit();
			}
			else {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Project> getProjectList(int managerId) {
		PreparedStatement ps, ps1;
		List<Project> pList = new ArrayList<Project>();
		try {
			ps = conn.prepareStatement("Select projid from team where userid=?");
			ps1 = conn.prepareStatement("Select * from project where id=?");
			ps.setInt(1, managerId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ps1.setInt(1, rs.getInt(1));
				System.out.println(rs.getInt(1));
				ResultSet rs1 = ps1.executeQuery();
				if (rs1.next()) {
					List<String> teamMembers = Stream.of(rs1.getString(6).split(", ", -1)).collect(Collectors.toList());
					pList.add(new Project(rs1.getInt(1), rs1.getString(2), rs1.getString(3),
							rs1.getDate(4).toLocalDate(), rs1.getString(5), teamMembers));
				}
			}
			return pList;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

}

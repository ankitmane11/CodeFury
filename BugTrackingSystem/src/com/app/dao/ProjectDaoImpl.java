package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.app.beans.Project;

public class ProjectDaoImpl implements ProjectDao {

	private static Connection conn;
	static {
		conn = DBUtil.getMyConnection();
	}

	public String getUserName(int id) {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select Name from User where User_ID=?");
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
		PreparedStatement ps, ps1;
		try {
			ps1 = conn.prepareStatement("insert into team values(?,?)");
			ps = conn.prepareStatement("insert into project values(?,?,?,?,?,?)");
			ResultSet rs1 = conn.prepareStatement("Select id from project").executeQuery();
			int id = 0;
			while (rs1.next()) {
				if (id < rs1.getInt(1))
					id = rs1.getInt(1);
			}
			ps.setInt(1, id+1);
			ps.setString(2, p.getName());
			ps.setString(3, p.getDescription());
			java.sql.Date sdat = new java.sql.Date(p.getStartDate().getTime());
			ps.setDate(4, sdat);
			ps.setString(5, p.getStatus());
			ps.setString(6, p.getTeamMembers());
			int num = ps.executeUpdate();
			if (num > 0) {
				ps1.setInt(2, id+1);
				for (int userId : team) {
					ps1.setInt(1, userId);
					int num1 = ps1.executeUpdate();
					if (num1 < 1) {
						break;
					}
				}
				conn.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Project> getProjectList(int managerId) {
		PreparedStatement ps, ps1;
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
					String dt = rs1.getDate(4).toString();
					Date date = sdf.parse(dt);
					pList.add(new Project(rs1.getInt(1), rs1.getString(2), rs1.getString(3), date, rs1.getString(5), rs1.getString(6)));
				}
			}
			return pList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

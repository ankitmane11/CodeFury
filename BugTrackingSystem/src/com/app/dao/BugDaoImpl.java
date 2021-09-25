package com.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.app.exceptions.BugNotAddedException;
import com.app.exceptions.BugNotFoundException;
import com.app.beans.Bugs;

import java.sql.Connection;
import java.sql.Date;

public class BugDaoImpl implements BugDao {
	private static Connection conn;
	static {
		conn = DBUtil.getMyConnection();
	}

	private int getProjectId(String projectName) {
		PreparedStatement getProjectIdStatement;
		try {
			getProjectIdStatement = conn.prepareStatement("Select projid from Project where name=?");
			getProjectIdStatement.setString(1, projectName);
			ResultSet rs = getProjectIdStatement.executeQuery();
			if (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	private int generateId() {
		PreparedStatement getIdsStatement;
		int id = 0;
		try {
			getIdsStatement = conn.prepareStatement("Select bugid from Bug");
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

	@Override
	public void createBug(String projectName, Bugs bug) throws BugNotFoundException, BugNotAddedException {
		try {
			PreparedStatement addBugStatement = conn
					.prepareStatement("insert into Bug values(?,?,?,?,?,?,?,?,?,?,?,?)");
			int id = generateId();
			addBugStatement.setInt(1, id);
			addBugStatement.setString(2, bug.getTitle());
			addBugStatement.setString(3, bug.getDescription());
			addBugStatement.setInt(4, getProjectId(projectName));
			addBugStatement.setInt(5, bug.getCreatedBy());
			addBugStatement.setDate(6, Date.valueOf(bug.getOpenDate()));
			addBugStatement.setInt(7, bug.getAssignedTo());
			addBugStatement.setBoolean(8, bug.getMarkedForClosing());
			addBugStatement.setInt(9, bug.getClosedBy());
			addBugStatement.setDate(10, null);
			addBugStatement.setString(11, bug.getStatus());
			addBugStatement.setString(12, bug.getSeverityLevel());

			int count = addBugStatement.executeUpdate();
			if (count == 1) {
				conn.commit();
				System.out.println("Bug Saved !");
			} else {
				conn.rollback();
				throw new BugNotAddedException("Could not add bug !");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public List<Bugs> getBugsForProject(int projectId) throws BugNotFoundException {
		PreparedStatement getBugStatement;
		LocalDate dt;
		List<Bugs> bList = new ArrayList<>();
		try {
			getBugStatement = conn.prepareStatement("Select * from Bug where projid = ?");
			getBugStatement.setInt(1, projectId);
			ResultSet rs = getBugStatement.executeQuery();
			// System.out.println(rs.next());
			while (rs.next()) {
				if (rs.getDate(10) == null)
					dt = null;
				else
					dt = rs.getDate(10).toLocalDate();
				bList.add(new Bugs(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getDate(6).toLocalDate(), rs.getInt(7), rs.getBoolean(8), rs.getInt(9), dt, rs.getString(11),
						rs.getString(12)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bList;
	}

	@Override
	public void assignBug(int userId, int bugId) throws BugNotFoundException {
		PreparedStatement assignBugStatement;
		try {
			assignBugStatement = conn.prepareStatement("Update Bug set assignedTo=? where bugid=?");
			assignBugStatement.setInt(1, userId);
			assignBugStatement.setInt(2, bugId);
			int count = assignBugStatement.executeUpdate();
			if (count == 1) {
				System.out.println("Bug Assigned");
			} else {
				throw new BugNotFoundException("No such bug found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void closeBug(int bugId) throws BugNotFoundException {
		PreparedStatement closeBugStatement;
		try {

			closeBugStatement = conn.prepareStatement("Update Bug set status=? where bugid=?");
			closeBugStatement.setString(1, "Closed");
			closeBugStatement.setInt(2, bugId);
			int count = closeBugStatement.executeUpdate();
			if (count == 1) {
				System.out.println("Bug Assigned");
				conn.commit();
			} else {
				conn.rollback();
				throw new BugNotFoundException("No such bug found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Bugs> getBugsForDeveloper(int userId) throws BugNotFoundException {
		List<Bugs> bList = new ArrayList<>();
		LocalDate dt;
		PreparedStatement getBugsStatement;
		try {
			getBugsStatement = conn.prepareStatement("select * from Bug where assignedTo=?");
			getBugsStatement.setInt(1, userId);
			ResultSet rs = getBugsStatement.executeQuery();
			while (rs.next()) {
				if (rs.getDate(10) == null)
					dt = null;
				else
					dt = rs.getDate(10).toLocalDate();
				bList.add(new Bugs(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getDate(6).toLocalDate(), rs.getInt(7), rs.getBoolean(8), rs.getInt(9), dt, rs.getString(11),
						rs.getString(12)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bList;
	}

	@Override
	public List<Bugs> getBugsForTester(int userId) throws BugNotFoundException {
		List<Bugs> bList = new ArrayList<>();
		LocalDate dt;
		PreparedStatement getBugsStatement;
		try {
			getBugsStatement = conn.prepareStatement("select * from Bug where createdBy=?");
			getBugsStatement.setInt(1, userId);
			ResultSet rs = getBugsStatement.executeQuery();
			while (rs.next()) {
				if (rs.getDate(10) == null)
					dt = null;
				else
					dt = rs.getDate(10).toLocalDate();
				bList.add(new Bugs(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getDate(6).toLocalDate(), rs.getInt(7), rs.getBoolean(8), rs.getInt(9), dt, rs.getString(11),
						rs.getString(12)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bList;
	}
}

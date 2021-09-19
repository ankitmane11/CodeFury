package com.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.app.Exceptions.BugNotAddedException;
import com.app.Exceptions.BugNotFoundException;
import com.app.beans.Bugs;


import java.sql.Connection;

public class BugDaoImpl implements BugDao{
	Connection conn = DBUtil.getMyConnection();

	
	@Override
	public void createBug(String projectName, Bugs bug) throws BugNotFoundException, BugNotAddedException {
		String projectNameQuery = "select Proj_ID from Project where Proj_Name='" + projectName + "'";
		int projectId = 0;
		try {
			PreparedStatement projectNameStatement = conn.prepareStatement(projectNameQuery);
			ResultSet resultSet = projectNameStatement.executeQuery();
			if (resultSet.next()) {
				int n = resultSet.getInt(0);
				if (n == 0) {
					throw new BugNotFoundException("Bug not found !");
				} else {
					projectId = n;
				}
			}

			// add object of like this in calling of method Bugs bug = new Bugs(bugTitle, bugDescription, projectId, createdById, openDate, severityLevel);
			PreparedStatement addBugStatement = conn.prepareStatement("insert into Bug values(?,?,?,?,?,?,?)");
			addBugStatement.setInt(1, bug.getId());
			addBugStatement.setString(2, bug.getTitle());
			addBugStatement.setString(3, bug.getDescription());
			addBugStatement.setString(4, bug.getStatus());
			addBugStatement.setInt(5, bug.getAssignedTo());// check
			addBugStatement.setInt(6, bug.getCreatedBy());// check
			addBugStatement.setInt(7, projectId);

			int count = addBugStatement.executeUpdate();
			if (count == 1) {
				System.out.println("Bug Saved !");
			} else {
				throw new BugNotAddedException("Could not add bug !");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}


	@Override
	public List<Bugs> getBugsForProject(int projectId) throws BugNotFoundException {
		// TODO Auto-generated method stub
		//id not in constructor
		//bug object has missing params
		return null;
	}


	@Override
	public void assignBug(int userId, int bugId) throws BugNotFoundException{
		//check assigned to is tester or dev
		
		try {
			String updateUserIdquery="update Bug set Dev_ID =? where Bug_ID =?";
			PreparedStatement updateUserIdStatement = conn.prepareStatement(updateUserIdquery);
			
			updateUserIdStatement.setInt(1, userId);
			updateUserIdStatement.setInt(2, bugId);
			int count = updateUserIdStatement.executeUpdate();
			if (count == 1) {
				System.out.println("Bug Assigned");
			}
			else {
				throw new BugNotFoundException("No such bug found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


	@Override
	public void closeBug(int bugId) throws BugNotFoundException {
		try {
			String closeBugQuery="update Bug set status=? where Bug_ID =?";
			PreparedStatement closeBugStatement = conn.prepareStatement(closeBugQuery);
			
			closeBugStatement.setString(1, "Closed");
			closeBugStatement.setInt(2, bugId);
			int count = closeBugStatement.executeUpdate();
			if (count == 1) {
				System.out.println("Bug Assigned");
			}
			else {
				throw new BugNotFoundException("No such bug found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	@Override
	public List<Bugs> getBugsForUser(int userId) throws BugNotFoundException {
		//params for constructormisssing in table 
		List<Bugs> bugList = new ArrayList<>();
		Bugs bug = null;

		try {
			
			PreparedStatement getBugsStatement = conn.prepareStatement("select * from Bug where Dev_ID =?");
			getBugsStatement.setInt(1, userId);

			ResultSet resultSet = getBugsStatement.executeQuery();
			if (!resultSet.next()) {
				throw new BugNotFoundException("No such bug found");
			} else {

				do {

					//bug = new Product(rs.getInt("PRODUCTID"), rs.getString("PRODUCTNAME"),
					//		rs.getString("DESCRIPTION"), rs.getDouble("PRICE"));
					//list.add(product);
				} while (resultSet.next());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bugList;
	}
}

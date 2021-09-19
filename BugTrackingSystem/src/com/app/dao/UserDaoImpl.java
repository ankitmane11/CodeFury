package com.app.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.app.beans.User;
import com.app.exceptions.EmailAlreadyExistsException;
import com.app.exceptions.EmailAndTypeMismatchException;
import com.app.exceptions.UserAlreadyRegisteredException;
import com.app.exceptions.UserDoesNotExistException;
import com.app.exceptions.UserNotRegisteredException;

public class UserDaoImpl implements UserDao {

	private static Connection conn;
	static {
		conn = DBUtil.getMyConnection();
	}

	@Override
	public void importUser(String path) throws EmailAlreadyExistsException {
		PreparedStatement ps, ps1;
		try {
			ps = conn.prepareStatement("insert into User values(null,?,?,null,?)");
			JSONParser jsonParser = new JSONParser();
			FileReader fr = new FileReader(path);
			JSONArray jArr = (JSONArray) jsonParser.parse(fr);
			int err = 0;
			for (Object ob : jArr) {
				JSONObject jObj = (JSONObject) ob;
				ps1 = conn.prepareStatement("Select Name from User where Email=?");
				ps1.setString(1, (String) jObj.get("email"));
				ResultSet rs = ps1.executeQuery();
				if (rs.next()) {
					err++;
					System.out.println((String) jObj.get("email") + " exists");
				} else {
					User u = new User((String) jObj.get("name"), (String) jObj.get("type"), (String) jObj.get("email"));
					System.out.println("Name: " + (String) jObj.get("name"));
					ps.setString(1, u.getName());
					ps.setString(2, u.getEmail());
					ps.setString(3, u.getType());
					int num = ps.executeUpdate();
					if (num > 0)
						conn.commit();
				}
			}
			if (err == 1)
				throw new EmailAlreadyExistsException(err + " email exists in the database");
			else if (err > 1) {
				throw new EmailAlreadyExistsException(err + " emails exist in the database");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void registerUser(String email, String type, String password) throws EmailAndTypeMismatchException, UserAlreadyRegisteredException, UserDoesNotExistException {
		PreparedStatement ps, ps1;
		try {
			ps = conn.prepareStatement("Select Role, Password from User where Email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(type) && rs.getString(2) == null) {
					ps1 = conn.prepareStatement("update User set User_ID=?, Password=? where Email=?");
					ResultSet rs1 = conn.prepareStatement("Select User_ID from User").executeQuery();
					int id = 0;
					while(rs1.next())
					{
						if(id<rs1.getInt(1))
							id = rs1.getInt(1);
					}
					ps1.setInt(1, id+1);
					ps1.setString(2, password);
					ps1.setString(3, email);
					int num = ps1.executeUpdate();
					if(num > 0)
						conn.commit();
				}
				else if (!rs.getString(1).equals(type)) {
					throw new EmailAndTypeMismatchException("Email and Type don't match");
				}
				else if(rs.getString(2) != null) {
					throw new UserAlreadyRegisteredException("User already registered");
				}
			}
			else {
				throw new UserDoesNotExistException("Not Found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public User userLogin(String email, String password) throws UserNotRegisteredException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("Select * from User where Email=? and Password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getString(3).equals(email) && rs.getString(4).equals(password))
					return new User(rs.getInt(1), rs.getString(2), rs.getString(5), rs.getString(3), rs.getString(4));
			}else {
				throw new UserNotRegisteredException("Please Register First");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

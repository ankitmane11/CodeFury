package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.app.beans.User;
import com.app.exceptions.EmailExistsException;
import com.app.exceptions.EmailAndTypeMismatchException;
import com.app.exceptions.UserAlreadyRegisteredException;
import com.app.exceptions.UserDoesNotExistException;
import com.app.exceptions.UserNotRegisteredException;

public class UserDaoImpl implements UserDao {

	private static Connection conn;
	static {
		conn = DBUtil.getMyConnection();
	}

	public int generateId() {
		PreparedStatement getIdsStatement;
		int id = 0;
		try {
			getIdsStatement = conn.prepareStatement("Select userid from User");
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
	public void importUser(List<User> uList) throws EmailExistsException {
		PreparedStatement storeUserStatement;
		try {
			storeUserStatement = conn.prepareStatement("insert into User (name,type,email) values(?,?,?)");
			int err = 0;
			for (User u : uList) {
				try {
					storeUserStatement.setString(1, u.getName());
					storeUserStatement.setString(2, u.getType());
					storeUserStatement.setString(3, u.getEmail());
					int num = storeUserStatement.executeUpdate();
					if (num > 0)
						conn.commit();
				} catch (SQLIntegrityConstraintViolationException e) {
					conn.rollback();
					err++;
				}
			}

			if (err == 1)
				throw new EmailExistsException(
						err + " email exists in the database, " + (uList.size() - err) + " entries added");
			else {
				throw new EmailExistsException(
						err + " emails exist in the database, " + (uList.size() - err) + " entries added");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void registerUser(String email, String type, String password)
			throws EmailAndTypeMismatchException, UserAlreadyRegisteredException, UserDoesNotExistException {
		PreparedStatement checkRegStatusStatement, registrationStatement;
		try {
			checkRegStatusStatement = conn.prepareStatement("Select password from User where email=?");
			checkRegStatusStatement.setString(1, email);
			ResultSet rs = checkRegStatusStatement.executeQuery();
			if (rs.next()) {
				if (rs.getString(1) == null) {
					registrationStatement = conn
							.prepareStatement("Update User set userid=?, password=? where email=? and type=?");
					int id = generateId();
					registrationStatement.setInt(1, id);
					registrationStatement.setString(2, password);
					registrationStatement.setString(3, email);
					registrationStatement.setString(4, type);
					int num = registrationStatement.executeUpdate();
					if (num > 0)
						conn.commit();
					else {
						conn.rollback();
						throw new EmailAndTypeMismatchException("Incorrect Input");
					}
				} else if (rs.getString(2).equals(password)) {
					throw new UserAlreadyRegisteredException("User already registered");
				}
			} else {
				throw new UserDoesNotExistException("Incorrect Input");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public User userLogin(String email, String password) throws UserNotRegisteredException {
		PreparedStatement getUserStatement;
		try {
			getUserStatement = conn.prepareStatement("Select * from User where Email=? and Password=?");
			getUserStatement.setString(1, email);
			getUserStatement.setString(2, password);
			ResultSet rs = getUserStatement.executeQuery();
			if (rs.next()) {
				if (rs.getString(4).equals(email) && rs.getString(5).equals(password))
					return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			} else {
				throw new UserNotRegisteredException("Please Register First");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

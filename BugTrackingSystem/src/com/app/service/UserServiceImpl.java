package com.app.service;

import java.util.List;

import com.app.beans.User;
import com.app.dao.UserDao;
import com.app.dao.UserDaoImpl;
import com.app.exceptions.EmailAlreadyExistsException;
import com.app.exceptions.EmailAndTypeMismatchException;
import com.app.exceptions.UserAlreadyRegisteredException;
import com.app.exceptions.UserDoesNotExistException;
import com.app.exceptions.UserNotRegisteredException;

public class UserServiceImpl implements UserService {

	private UserDao uDao;
	public UserServiceImpl() {
		uDao = new UserDaoImpl();
	}
	
	@Override
	public void importUser(String path) throws EmailAlreadyExistsException {
		uDao.importUser(path);
	}

	@Override
	public void registerUser(String email, String type, String password) throws EmailAndTypeMismatchException, UserAlreadyRegisteredException, UserDoesNotExistException {
		uDao.registerUser(email, type, password);
	}

	@Override
	public User userLogin(String email, String password) throws UserNotRegisteredException {
		return uDao.userLogin(email,password);
	}

}

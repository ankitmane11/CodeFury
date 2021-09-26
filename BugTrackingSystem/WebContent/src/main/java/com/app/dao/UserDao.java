package com.app.dao;

import java.util.List;

import com.app.beans.User;
import com.app.exceptions.EmailExistsException;
import com.app.exceptions.EmailAndTypeMismatchException;
import com.app.exceptions.UserAlreadyRegisteredException;
import com.app.exceptions.UserDoesNotExistException;
import com.app.exceptions.UserNotRegisteredException;

public interface UserDao {

	void importUser(List<User> uList) throws EmailExistsException;

	void registerUser(String email, String type, String password) throws EmailAndTypeMismatchException, UserAlreadyRegisteredException, UserDoesNotExistException;

	User userLogin(String email, String password) throws UserNotRegisteredException;

}

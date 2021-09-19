package com.app.dao;

import com.app.beans.User;
import com.app.exceptions.EmailAlreadyExistsException;
import com.app.exceptions.EmailAndTypeMismatchException;
import com.app.exceptions.UserAlreadyRegisteredException;
import com.app.exceptions.UserDoesNotExistException;
import com.app.exceptions.UserNotRegisteredException;

public interface UserDao {

	void importUser(String path) throws EmailAlreadyExistsException;

	void registerUser(String email, String type, String password) throws EmailAndTypeMismatchException, UserAlreadyRegisteredException, UserDoesNotExistException;

	User userLogin(String email, String password) throws UserNotRegisteredException;

}

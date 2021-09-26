package com.app.exceptions;

public class UserAlreadyRegisteredException extends Exception {

	public UserAlreadyRegisteredException() {
		super();
	}

	public UserAlreadyRegisteredException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserAlreadyRegisteredException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserAlreadyRegisteredException(String message) {
		super(message);
	}

	public UserAlreadyRegisteredException(Throwable cause) {
		super(cause);
	}

}

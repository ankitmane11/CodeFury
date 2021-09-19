package com.app.exceptions;

public class UserNotRegisteredException extends Exception {

	public UserNotRegisteredException() {
		super();
	}

	public UserNotRegisteredException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserNotRegisteredException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNotRegisteredException(String message) {
		super(message);
	}

	public UserNotRegisteredException(Throwable cause) {
		super(cause);
	}

}

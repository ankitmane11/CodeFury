package com.app.exceptions;

public class EmailAlreadyExistsException extends Exception {

	public EmailAlreadyExistsException() {
		super();
	}

	public EmailAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmailAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmailAlreadyExistsException(String message) {
		super(message);
	}

	public EmailAlreadyExistsException(Throwable cause) {
		super(cause);
	}

}

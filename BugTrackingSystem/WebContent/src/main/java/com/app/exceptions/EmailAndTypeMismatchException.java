package com.app.exceptions;

public class EmailAndTypeMismatchException extends Exception {

	public EmailAndTypeMismatchException() {
		super();
	}

	public EmailAndTypeMismatchException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmailAndTypeMismatchException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmailAndTypeMismatchException(String message) {
		super(message);
	}

	public EmailAndTypeMismatchException(Throwable cause) {
		super(cause);
	}

}

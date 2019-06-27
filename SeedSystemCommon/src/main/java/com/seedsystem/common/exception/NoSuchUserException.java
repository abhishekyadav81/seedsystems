package com.seedsystem.common.exception;

public class NoSuchUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9076069889140934759L;

	public NoSuchUserException() {
		super();
	}


	public NoSuchUserException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NoSuchUserException(String arg0) {
		super(arg0);
	}

}

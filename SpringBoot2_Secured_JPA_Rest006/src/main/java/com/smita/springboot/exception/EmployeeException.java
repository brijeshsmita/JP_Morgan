package com.smita.springboot.exception;
/** @author Smita **/
public class EmployeeException extends Exception {
	private static final long serialVersionUID = -1648287564068549359L;

	public EmployeeException() {
		super();
	}
	public EmployeeException(String message) {
		super(message);
	}
}

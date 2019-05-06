/**
 * 
 */
package com.smita.springboot.exception;

/**
 * @author Smita B Kumar
 *
 */
public class EmployeeAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1983722952009982485L;

	/**
	 * 
	 */
	public EmployeeAlreadyExistsException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public EmployeeAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public EmployeeAlreadyExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public EmployeeAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public EmployeeAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}

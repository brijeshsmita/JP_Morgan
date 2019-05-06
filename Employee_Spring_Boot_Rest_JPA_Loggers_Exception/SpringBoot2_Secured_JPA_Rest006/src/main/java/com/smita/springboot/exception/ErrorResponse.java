/**
 * 
 */
package com.smita.springboot.exception;

import java.util.List;

/**
 * @author Smita B Kumar
 *
 */
public class ErrorResponse {
	private String message;
	private List<String> details;
	public ErrorResponse(String message, List<String> details) {
		super();
		this.message = message;
		this.details = details;
	}
	
}

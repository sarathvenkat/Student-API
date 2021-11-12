/**
 * 
 */
package com.jpms.crs.exception;

/**
 * @author Administrator
 *
 */
public class StudentNotFound extends RuntimeException{
	
	private String message;
	
	public StudentNotFound(String message) {
		super(message);
	}
}

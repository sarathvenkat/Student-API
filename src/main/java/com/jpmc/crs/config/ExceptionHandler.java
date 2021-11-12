/**
 * 
 */
package com.jpmc.crs.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.jpmc.crs.view.Error;
import com.jpms.crs.exception.StudentNotFound;

/**
 * @author Administrator
 *
 */
@ControllerAdvice
public class ExceptionHandler {

	
	@org.springframework.web.bind.annotation.ExceptionHandler(StudentNotFound.class)
	public ResponseEntity<Error> studentNotFound() {
		Error error = new Error("Not Found","NOT_FOUND");
		return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
	}
	
}

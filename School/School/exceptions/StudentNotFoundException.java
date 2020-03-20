package com.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class StudentNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	@ExceptionHandler(StudentNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> exception(StudentNotFoundException exception) {
		return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
	}

}

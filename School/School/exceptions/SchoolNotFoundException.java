package com.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class SchoolNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	@ExceptionHandler(SchoolNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> exception(SchoolNotFoundException exception) {
		return new ResponseEntity<>("School not found", HttpStatus.NOT_FOUND);
	}
}

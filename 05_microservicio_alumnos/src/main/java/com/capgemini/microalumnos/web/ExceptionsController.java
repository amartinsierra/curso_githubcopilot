package com.capgemini.microalumnos.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.caixaba.absis.microalumnos.exceptions.AlumnoAlreadyExistsException;
@org.springframework.web.bind.annotation.RestControllerAdvice
public class ExceptionsController {

	@ExceptionHandler(AlumnoAlreadyExistsException.class)
	public ResponseEntity<String> handleAlumnoAlreadyExistsException(AlumnoAlreadyExistsException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}

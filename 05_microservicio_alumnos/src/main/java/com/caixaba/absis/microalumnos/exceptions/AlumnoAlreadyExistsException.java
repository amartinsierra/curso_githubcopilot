package com.caixaba.absis.microalumnos.exceptions;

public class AlumnoAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AlumnoAlreadyExistsException(String message) {
		super(message);
	}
}

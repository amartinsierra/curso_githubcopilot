package com.caixaba.absis.micropersonas.exceptions;

public class PersonaAlreadyExistsException extends RuntimeException {
	public PersonaAlreadyExistsException(Integer id) {
		super("Ya existe una persona con id: " + id);
	}
}

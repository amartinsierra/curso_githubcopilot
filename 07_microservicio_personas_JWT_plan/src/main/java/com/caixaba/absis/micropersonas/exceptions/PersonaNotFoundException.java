package com.caixaba.absis.micropersonas.exceptions;

public class PersonaNotFoundException extends RuntimeException {
	public PersonaNotFoundException(Integer id) {
		super("No se ha encontrado la persona con id: " + id);
	}
}

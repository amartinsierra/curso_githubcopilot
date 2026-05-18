package com.capgemini.micropersonas.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.caixaba.absis.micropersonas.exceptions.PersonaAlreadyExistsException;
import com.caixaba.absis.micropersonas.exceptions.PersonaNotFoundException;
@RestControllerAdvice
public class ExceptionsController {

	//Crea un método para manejar la excepción PersonaNotFoundException, que devuelva un mensaje de error y un código de estado 404
	@ExceptionHandler(PersonaNotFoundException.class)
	public ResponseEntity<String> handlePersonaNotFoundException(PersonaNotFoundException ex) {
		return ResponseEntity.status(404).body(ex.getMessage());
	}
	
	//Crea un método para manejar la excepción PersonaAlreadyExistsException, que devuelva un mensaje de error y un código de estado 409
	@ExceptionHandler(PersonaAlreadyExistsException.class)
	public ResponseEntity<String> handlePersonaAlreadyExistsException(PersonaAlreadyExistsException ex) {
		return ResponseEntity.status(409).body(ex.getMessage());
	}
}

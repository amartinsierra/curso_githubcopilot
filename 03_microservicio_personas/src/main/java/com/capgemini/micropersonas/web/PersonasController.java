package com.capgemini.micropersonas.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.caixaba.absis.micropersonas.service.PersonasService;
import com.capgemini.micropersonas.api.PersonasApi;
import com.capgemini.micropersonas.api.domain.Persona;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
@RestController
public class PersonasController implements PersonasApi {
	//declara una variable PersonasService e inyectala en el constructor de la clase. Esta variable se usará para llamar a los métodos del servicio desde el controlador
	private PersonasService personasService;
	public PersonasController(PersonasService personasService) {
		this.personasService = personasService;
	}
	

	@Override
	public ResponseEntity<List<Persona>> personasEdadesGet(@NotNull @Valid Integer min, @NotNull @Valid Integer max) {
		return ResponseEntity.ok(personasService.getPersonasByEdadRange(min, max));
	}

	@Override
	public ResponseEntity<List<Persona>> personasGet() {
		return ResponseEntity.ok(personasService.getAllPersonas());
	}

	@Override
	public ResponseEntity<Persona> personasIdDelete(Integer id) {
		return ResponseEntity.ok(personasService.deletePersonaById(id));
	}

	@Override
	public ResponseEntity<Persona> personasIdGet(Integer id) {
		//Si la persona existe, devuelve un ResponseEntity con el status 200 y la persona encontrada. Si no existe, devuelve un ResponseEntity con el status 404
		Persona persona = personasService.getPersonaById(id);
		if (persona != null) {
			return ResponseEntity.ok(persona);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	public ResponseEntity<Persona> personasPost(@Valid Persona persona) {
		//devuelve un ResponseEntity con el status 201 y la persona creada
		return ResponseEntity.status(201).body(personasService.createPersona(persona));
	}

}

package com.capgemini.micropersonas.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.micropersonas.api.PersonasApi;
import com.capgemini.micropersonas.api.domain.Persona;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
@RestController
public class PersonasController implements PersonasApi {

	@Override
	public ResponseEntity<List<Persona>> personasEdadesGet(@NotNull @Valid Integer min, @NotNull @Valid Integer max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<Persona>> personasGet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Persona> personasIdDelete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Persona> personasIdGet(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Persona> personasPost(@Valid Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

}

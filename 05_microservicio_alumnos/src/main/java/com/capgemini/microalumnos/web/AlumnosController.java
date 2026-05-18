package com.capgemini.microalumnos.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.microalumnos.api.AlumnosApi;
import com.capgemini.microalumnos.api.domain.Alumno;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
@RestController
public class AlumnosController implements AlumnosApi {

	@Override
	public ResponseEntity<Void> createAlumno(@Valid Alumno alumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<Alumno>> getAllAlumnos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<Alumno>> getAlumnosByCurso(@NotNull @Valid String curso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<String>> getCursos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> updateCalificaciones(@NotNull @Valid String curso, @NotNull @Valid Double valor) {
		// TODO Auto-generated method stub
		return null;
	}

}

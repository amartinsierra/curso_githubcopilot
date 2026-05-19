package com.capgemini.microalumnos.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.caixaba.absis.microalumnos.service.AlumnosService;
import com.capgemini.microalumnos.api.AlumnosApi;
import com.capgemini.microalumnos.api.domain.Alumno;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
@RestController
public class AlumnosController implements AlumnosApi {
	//Declara una variable de tipo AlumnosService e inyecta su implementación a través del constructor.
	private final AlumnosService alumnosService;
	public AlumnosController(AlumnosService alumnosService) {
		this.alumnosService = alumnosService;
	}
	@Override
	public ResponseEntity<Void> createAlumno(@Valid Alumno alumno) {
		//añade un nuevo alumno utilizando el servicio y devuelve 201
		alumnosService.createAlumno(alumno);
		return ResponseEntity.status(201).build();
	}

	@Override
	public ResponseEntity<List<Alumno>> getAllAlumnos() {
		return ResponseEntity.ok(alumnosService.getAllAlumnos());
	}

	@Override
	public ResponseEntity<List<Alumno>> getAlumnosByCurso(@NotNull @Valid String curso) {
		return ResponseEntity.ok(alumnosService.getAlumnosByCurso(curso));
	}

	@Override
	public ResponseEntity<List<String>> getCursos() {
		return ResponseEntity.ok(alumnosService.getCursos());
	}

	@Override
	public ResponseEntity<Void> updateCalificaciones(@NotNull @Valid String curso, @NotNull @Valid Double valor) {
		alumnosService.updateCalificaciones(curso, valor);
		return ResponseEntity.ok().build();
	}

}

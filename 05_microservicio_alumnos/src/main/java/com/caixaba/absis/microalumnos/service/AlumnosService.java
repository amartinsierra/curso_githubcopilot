package com.caixaba.absis.microalumnos.service;

public interface AlumnosService {
	//Método que crea un nuevo alumno. Si ya existe un alumno con el mismo dni y curso, se lanzará una excepción.
	void createAlumno(com.capgemini.microalumnos.api.domain.Alumno alumno);
	
	//Método que devuelve la lista de todos los alumnos.
	java.util.List<com.capgemini.microalumnos.api.domain.Alumno> getAllAlumnos();
	
	//Método que devuelve la lista de alumnos de un curso determinado.
	java.util.List<com.capgemini.microalumnos.api.domain.Alumno> getAlumnosByCurso(String curso);
	
	//Método que devuelve la lista de cursos sin repetidos.
	java.util.List<String> getCursos();
	
	//Método que actualiza la calificación de todos los alumnos de un curso, añadiendo la cantidad recibida al valor actual.
	void updateCalificaciones(String curso, Double valor);
}

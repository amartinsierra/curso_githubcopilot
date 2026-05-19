package com.caixaba.absis.microalumnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caixaba.absis.microalumnos.entity.AlumnoEntity;

public interface AlumnosRepository extends JpaRepository<AlumnoEntity, String> {
	//Método que devuelve la lista de cursos sin repetidos
	@org.springframework.data.jpa.repository.Query("SELECT DISTINCT a.curso FROM AlumnoEntity a")
	java.util.List<String> findDistinctCursos();
	
	//Método que devuelve la lista de alumnos de un curso. No utilices JPQL, utiliza el método de consulta derivada de Spring Data JPA
	java.util.List<AlumnoEntity> findByCurso(String curso);
	
	//Método que actualiza la calificación de todos los alumnos de un curso, añadiendo la cantidad recibida al valor actual.
	@org.springframework.data.jpa.repository.Modifying
	@org.springframework.data.jpa.repository.Query("UPDATE AlumnoEntity a SET a.calificacion = a.calificacion + :valor WHERE a.curso = :curso")
	void updateCalificacionesByCurso(@org.springframework.data.repository.query.Param("curso") String curso, @org.springframework.data.repository.query.Param("valor") Double valor);
	
	//Método que indique si existe una determinada combinación de curso y dni
	boolean existsByCursoAndDni(String curso, String dni);
}
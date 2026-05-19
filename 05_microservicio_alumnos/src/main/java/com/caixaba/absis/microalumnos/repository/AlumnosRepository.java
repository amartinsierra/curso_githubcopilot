package com.caixaba.absis.microalumnos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.caixaba.absis.microalumnos.entity.AlumnoEntity;

public interface AlumnosRepository extends JpaRepository<AlumnoEntity, String> {
	//Método que devuelve la lista de cursos sin repetidos
	@Query("SELECT DISTINCT a.curso FROM AlumnoEntity a")
	List<String> findDistinctCursos();
	
	//Método que devuelve la lista de alumnos de un curso. No utilices JPQL, utiliza el método de consulta derivada de Spring Data JPA
	List<AlumnoEntity> findByCurso(String curso);
	
	//Método que actualiza la calificación de todos los alumnos de un curso, añadiendo la cantidad recibida al valor actual.
	@Modifying
	@Query("UPDATE AlumnoEntity a SET a.calificacion = a.calificacion + :valor WHERE a.curso = :curso")
	void updateCalificacionesByCurso(@Param("curso") String curso, @Param("valor") Double valor);
	
	//Método que indique si existe una determinada combinación de curso y dni
	Boolean existsByCursoAndDni(String curso, String dni);
}
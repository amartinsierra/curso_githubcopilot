package com.caixaba.absis.microalumnos.mapper;

import org.springframework.stereotype.Component;

import com.caixaba.absis.microalumnos.entity.AlumnoEntity;
import com.capgemini.microalumnos.api.domain.Alumno;

@Component
public class AlumnoMapper {
	public AlumnoEntity toEntity(Alumno alumno) {
		if (alumno == null) {
			return null;
		}
		return new AlumnoEntity(alumno.getDni(), alumno.getNombre(), alumno.getCurso(), alumno.getCalificacion());
	}

	public Alumno toDomain(AlumnoEntity entity) {
		if (entity == null) {
			return null;
		}
		return new Alumno(entity.getDni(), entity.getNombre(), entity.getCurso(), entity.getCalificacion());
	}
}

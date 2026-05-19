package com.caixaba.absis.microalumnos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.caixaba.absis.microalumnos.exceptions.AlumnoAlreadyExistsException;
import com.caixaba.absis.microalumnos.mapper.AlumnoMapper;
import com.caixaba.absis.microalumnos.repository.AlumnosRepository;
import com.capgemini.microalumnos.api.domain.Alumno;
@Service
public class AlumnosServiceImpl implements AlumnosService {

	private final AlumnosRepository alumnosRepository;
	private final AlumnoMapper alumnoMapper;
	public AlumnosServiceImpl(AlumnosRepository alumnosRepository, AlumnoMapper alumnoMapper) {
		this.alumnosRepository = alumnosRepository;
		this.alumnoMapper = alumnoMapper;
	}
	@Override
	public void createAlumno(Alumno alumno) {
		//añade el alumno a la base de datos. Si ya existe un alumno con el mismo dni y curso, se lanzará una excepción AlumnoAlreadyExistsException
		if (alumnosRepository.existsByCursoAndDni(alumno.getCurso(), alumno.getDni())) {
			throw new AlumnoAlreadyExistsException("El alumno con dni " + alumno.getDni() + " ya existe en el curso " + alumno.getCurso());
		}
		alumnosRepository.save(alumnoMapper.toEntity(alumno));

	}

	@Override
	public List<Alumno> getAllAlumnos() {
		return alumnosRepository.findAll().stream().map(alumnoMapper::toDomain).toList();
	}

	@Override
	public List<Alumno> getAlumnosByCurso(String curso) {
		//si la lista de alumnos del curso está vacía, se lanzará una excepción IllegalArgumentException con el mensaje "No existen alumnos en el curso " + curso
		List<Alumno> alumnos = alumnosRepository.findByCurso(curso).stream().map(alumnoMapper::toDomain).toList();
		if (alumnos.isEmpty()) {
			throw new IllegalArgumentException("No existen alumnos en el curso " + curso);
		}
		return alumnos;
	}

	@Override
	public List<String> getCursos() {
		return alumnosRepository.findDistinctCursos();
	}

	@Override
	public void updateCalificaciones(String curso, Double valor) {
		alumnosRepository.updateCalificacionesByCurso(curso, valor);

	}

}

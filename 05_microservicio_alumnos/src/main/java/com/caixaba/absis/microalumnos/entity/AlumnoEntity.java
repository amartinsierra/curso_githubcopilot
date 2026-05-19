package com.caixaba.absis.microalumnos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alumnos")
public class AlumnoEntity {
	@Id
	private String dni;
	private String nombre;
	private String curso;
	private Double calificacion;

	public AlumnoEntity() {
		super();
	}

	public AlumnoEntity(String dni, String nombre, String curso, Double calificacion) {
		this.dni = dni;
		this.nombre = nombre;
		this.curso = curso;
		this.calificacion = calificacion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Double calificacion) {
		this.calificacion = calificacion;
	}
}

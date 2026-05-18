package com.caixaba.absis.micropersonas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas")
public class PersonaEntity {
	// Atributos de la entidad PersonaEntity, que son los mismos que los de la clase Persona
	@jakarta.persistence.Id
	private Long id;
	private String nombre;
	private String email;
	private Integer edad;
	
	// Constructor vacío
	public PersonaEntity() {
		super();
	}
	// Constructor con parámetros
	public PersonaEntity(Long id, String nombre, String email, Integer edad) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
	}
	// Getters y Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
}

package com.caixaba.absis.micropersonas.service;

import java.util.List;

import com.capgemini.micropersonas.api.domain.Persona;

public interface PersonasService {
	//a partir de los métodos definidos en el controlador PersonasController, declara los métodos que se van a necesitar
	//en la implementación del servicio
	//método para obtener todas las personas
	public List<Persona> getAllPersonas();
	//método para obtener una persona por su id
	public Persona getPersonaById(Integer id);
	//método para crear una persona
	public Persona createPersona(Persona persona);
	//método para eliminar una persona por su id
	public Persona deletePersonaById(Integer id);
	//método para obtener personas por rango de edad
	public List<Persona> getPersonasByEdadRange(Integer min, Integer max);
	
}

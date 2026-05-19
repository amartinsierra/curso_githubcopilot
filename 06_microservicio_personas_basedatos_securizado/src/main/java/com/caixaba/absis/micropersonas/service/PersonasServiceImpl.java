package com.caixaba.absis.micropersonas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.caixaba.absis.micropersonas.exceptions.PersonaAlreadyExistsException;
import com.caixaba.absis.micropersonas.exceptions.PersonaNotFoundException;
import com.caixaba.absis.micropersonas.mapper.PersonaMapper;
import com.caixaba.absis.micropersonas.repository.PersonasRepository;
import com.capgemini.micropersonas.api.domain.Persona;
@Service
public class PersonasServiceImpl implements PersonasService {
	//declara una variable PersonasRepository y una variable PersonaMapper, e inyectalas a través del constructor
	PersonasRepository personasRepository;
	PersonaMapper personaMapper;
	public PersonasServiceImpl(PersonasRepository personasRepository, PersonaMapper personaMapper) {
		this.personasRepository = personasRepository;
		this.personaMapper = personaMapper;
	}
	@Override
	public List<Persona> getAllPersonas() {
		return personasRepository.findAll().stream().map(personaMapper::toPersona).toList();
	}

	@Override
	public Persona getPersonaById(Integer id) {
		return personasRepository.findById(id.longValue()).map(personaMapper::toPersona).orElse(null);
	}

	@Override
	public Persona createPersona(Persona persona) {
		//añade la persona solo si no existe una persona con el mismo id.
		//de vuelve la persona creada, o lanza una PersonaAlreadyExistsException si ya existe una persona con el mismo id
		if (getPersonaById(persona.getId()) == null) {
			return personaMapper.toPersona(personasRepository.save(personaMapper.toPersonaEntity(persona)));
		} else {
			throw new PersonaAlreadyExistsException(persona.getId());
		}
		
	}

	@Override
	public Persona deletePersonaById(Integer id) {
		//si existe una persona con el id, la elimina y devuelve la persona eliminada. Si no existe, 
		//genera una PersonaNotFoundException
		Persona persona = getPersonaById(id);
		if (persona != null) {
			personasRepository.deleteById(id.longValue());
			return persona;
		} else {
			throw new PersonaNotFoundException(id);
		}
		

	}

	@Override
	public List<Persona> getPersonasByEdadRange(Integer min, Integer max) {
		return personasRepository.findByEdadBetween(min, max).stream().map(personaMapper::toPersona).toList();
	}

}

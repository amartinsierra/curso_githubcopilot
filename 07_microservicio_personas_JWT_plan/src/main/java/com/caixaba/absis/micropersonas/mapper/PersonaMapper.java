package com.caixaba.absis.micropersonas.mapper;

import org.mapstruct.Mapper;

import com.caixaba.absis.micropersonas.entity.PersonaEntity;
import com.capgemini.micropersonas.api.domain.Persona;

@Mapper(componentModel = "spring")
public interface PersonaMapper {
	//método para convertir una PersonaEntity a una Persona
	Persona toPersona(PersonaEntity personaEntity);
	
	//método para convertir una Persona a una PersonaEntity
	PersonaEntity toPersonaEntity(Persona persona);
}

package com.caixaba.absis.micropersonas.mapper;

import org.springframework.stereotype.Component;

@Component
public class PersonaMapper {
	//método para convertir una PersonaEntity a una Persona
	public com.capgemini.micropersonas.api.domain.Persona toPersona(com.caixaba.absis.micropersonas.entity.PersonaEntity personaEntity) {
		return new com.capgemini.micropersonas.api.domain.Persona(
				personaEntity.getId().intValue(),
				personaEntity.getNombre(),
				personaEntity.getEdad(),
				personaEntity.getEmail()
				);
	}
	
	//método para convertir una Persona a una PersonaEntity
	public com.caixaba.absis.micropersonas.entity.PersonaEntity toPersonaEntity(com.capgemini.micropersonas.api.domain.Persona persona) {
		return new com.caixaba.absis.micropersonas.entity.PersonaEntity(
				persona.getId().longValue(),
				persona.getNombre(),
				persona.getEmail(),
				persona.getEdad()
				);
	}
}

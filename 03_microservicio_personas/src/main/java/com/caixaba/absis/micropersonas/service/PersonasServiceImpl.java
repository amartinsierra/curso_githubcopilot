package com.caixaba.absis.micropersonas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.micropersonas.api.domain.Persona;
@Service
public class PersonasServiceImpl implements PersonasService {
	//Crea una lista de personas para simular una base de datos. La lista deberá permitir
	//añadir y eliminar personas. Y quiero que te inventes al menos 5 personas con diferentes datos
	private List<Persona> personas =new ArrayList<>(List.of(
			new Persona(1, "Juan", 30, "juan.gmail.com"),
			new Persona(2, "Maria", 25, "maria.gmail.com"),
			new Persona(3, "Pedro", 40, "pedro.gmail.com"),
			new Persona(4, "Ana", 35, "ana.gmail.com"),
			new Persona(5, "Luis", 20, "luis.gmail.com")
			));
	@Override
	public List<Persona> getAllPersonas() {
		return personas;
	}

	@Override
	public Persona getPersonaById(Integer id) {
		return personas.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
	}

	@Override
	public Persona createPersona(Persona persona) {
		//añade la persona solo si no existe una persona con el mismo id.
		//de vuelve la persona creada, o null si no se ha podido crear
		if (personas.stream().anyMatch(p -> p.getId().equals(persona.getId()))) {
			return null;
		}
		personas.add(persona);
		return persona;
	}

	@Override
	public void deletePersonaById(Integer id) {
		personas.removeIf(p -> p.getId().equals(id));

	}

	@Override
	public List<Persona> getPersonasByEdadRange(Integer min, Integer max) {
		return personas.stream().filter(p -> p.getEdad() >= min && p.getEdad() <= max).toList();
	}

}

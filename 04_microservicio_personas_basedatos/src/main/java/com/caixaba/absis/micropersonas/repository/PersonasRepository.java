package com.caixaba.absis.micropersonas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caixaba.absis.micropersonas.entity.PersonaEntity;

public interface PersonasRepository extends JpaRepository<PersonaEntity, Long> {
	// El JpaRepository ya proporciona métodos para realizar operaciones CRUD básicas, 
	// por lo que no es necesario definir ningún método adicional aquí a menos que quieras agregar consultas personalizadas.
	
	//método para obtener personas por rango de edad
	List<PersonaEntity> findByEdadBetween(Integer min, Integer max);
	
	//método para obtener el total de personas mayores de una edad determinada, usando JPQL
	@org.springframework.data.jpa.repository.Query("SELECT COUNT(p) FROM PersonaEntity p WHERE p.edad > :edad")
	Long countByEdadGreaterThan(Integer edad);

}

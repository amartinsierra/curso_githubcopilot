package com.capgemini.microalumnos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
	scanBasePackages = {
		"com.caixaba.absis.microalumnos",
		"com.capgemini.microalumnos"
	}
)
@EntityScan(basePackages = "com.caixaba.absis.microalumnos.entity")
@EnableJpaRepositories(basePackages = "com.caixaba.absis.microalumnos.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

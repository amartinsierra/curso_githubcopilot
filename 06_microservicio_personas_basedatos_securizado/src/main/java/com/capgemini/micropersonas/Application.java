package com.capgemini.micropersonas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
		scanBasePackages = {
				"com.caixaba.absis.micropersonas.service",
				"com.capgemini.micropersonas.web",
				"com.caixaba.absis.micropersonas.mapper"
		}
)
//escanea paquete del repositorio
@EntityScan(basePackages = "com.caixaba.absis.micropersonas.entity")
@EnableJpaRepositories(basePackages = "com.caixaba.absis.micropersonas.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

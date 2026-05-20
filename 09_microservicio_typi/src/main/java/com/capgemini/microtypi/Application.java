package com.capgemini.microtypi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
//escanea paquetes de controlador y service
@SpringBootApplication(scanBasePackages = {"com.caixaba.absis.microtypi.service", "com.capgemini.microtypi.web"})

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public RestClient.Builder restClientBuilder() {
		return RestClient.builder();
	}

}
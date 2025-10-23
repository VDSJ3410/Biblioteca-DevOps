package com.inube.biblioteca_registry_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BibliotecaRegistryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaRegistryServiceApplication.class, args);
	}

}

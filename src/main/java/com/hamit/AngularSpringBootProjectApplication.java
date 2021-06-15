package com.hamit;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// @SpringBootApplication(scanBasePackages = { "com.hamit.service",
// "com.hamit.service.impl" })
// @ComponentScan(basePackages = { "com.hamit.service", "com.hamit.service.impl"
// })

public class AngularSpringBootProjectApplication {
	
	// psvm
	public static void main(String[] args) {
		SpringApplication.run(AngularSpringBootProjectApplication.class, args);
	}
	
	// model mapper
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
}

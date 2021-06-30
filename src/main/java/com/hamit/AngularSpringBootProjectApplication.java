package com.hamit;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

// @SpringBootApplication(scanBasePackages = { "com.hamit.service",
// "com.hamit.service.impl" })
// @ComponentScan(basePackages = { "com.hamit.service", "com.hamit.service.impl"
// })

@SpringBootApplication
public class AngularSpringBootProjectApplication extends SpringBootServletInitializer {
	
	// deployment icin eklendi
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(AngularSpringBootProjectApplication.class);
	}
	
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

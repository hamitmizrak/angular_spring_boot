package com.hamit.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
	// http://localhost:9293
	// localhost:9293/swagger-ui.html
	// http://localhost:9293/explorer/index.html#uri=/
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("title:Hamit Mızrak 15 Haziran 2021")
				.description("description:Angular Spring Boot").termsOfServiceUrl("http://www.hamitmizrak.com.tr")
				.license("license:for Java Angular HamitMizrak")
				// .contact(+90 1111 222 333)
				.version("1.0.0").build();
	}
	
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.hamit")).build().pathMapping("/")
				.useDefaultResponseMessages(false).directModelSubstitute(LocalDate.class, String.class)
				.genericModelSubstitutes(ResponseEntity.class);
	}
	
}

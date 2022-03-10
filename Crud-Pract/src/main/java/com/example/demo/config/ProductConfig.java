package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex; 

@Configuration
@EnableSwagger2

public class ProductConfig {
	
	@Bean
	public Docket postApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Technique").apiInfo(apiInfo()).select()
				.paths(regex("/prod.*")).build();
		
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Product Service")
				.description("Sample Documentation Generated Using SWAGGER2 for our Product Rest API")
				.termsOfServiceUrl("https://www.dreams.com/vill/abcd")
				.license("Java_Gyan_Mantra License")
				.licenseUrl("https://www.dreams.com/vill/abcd").version("1.0").build();
	}
	

}

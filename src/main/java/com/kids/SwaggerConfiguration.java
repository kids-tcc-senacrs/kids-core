package com.kids;

import org.springframework.context.annotation.Bean;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

// @Configuration
// @EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
	return new Docket(DocumentationType.SWAGGER_2)//
	        .select().apis(RequestHandlerSelectors.any())//
	        .paths(Predicates.not(PathSelectors.regex("/error")))//
	        .build();//
    }

}
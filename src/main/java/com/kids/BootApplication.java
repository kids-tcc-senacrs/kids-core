package com.kids;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 05/2017
 * 
 */
@Configuration
@EnableSwagger2
@EnableAutoConfiguration
@SpringBootApplication
@EnableJpaRepositories
public class BootApplication {

    public static void main(String[] args) {
	SpringApplication.run(BootApplication.class, args);
    }





    @Bean
    public WebMvcConfigurer corsConfigurer() {
	return new WebMvcConfigurerAdapter() {

	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")//
		        .allowedOrigins("http://localhost:4200", "https://kids-web.herokuapp.com")//
		        .allowedMethods("GET", "POST", "OPTIONS", "PUT")//
		        .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers")//
		        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")//
		        .allowCredentials(true)//
		        .maxAge(3600);//
	    }
	};
    }





    @Bean
    public Docket api() {
	return new Docket(DocumentationType.SWAGGER_2)//
	        .select().apis(RequestHandlerSelectors.any())//
	        .paths(Predicates.not(PathSelectors.regex("/error")))//
	        .build();//
    }

}
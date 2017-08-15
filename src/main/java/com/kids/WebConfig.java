package com.kids;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(final CorsRegistry registry) {
	registry.addMapping("/**")//
	        .allowedOrigins("*")//
	        .allowedMethods("GET", "POST", "OPTIONS", "PUT", "DELETE")//
	        .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers")//
	        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")//
	        .allowCredentials(true)//
	        .maxAge(3600);//
    }
}
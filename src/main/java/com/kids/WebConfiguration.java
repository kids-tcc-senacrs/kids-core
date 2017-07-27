package com.kids;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addCorsMappings(final CorsRegistry registry) {
		registry.addMapping("/**")//
				.allowedOrigins("https://kids-web.herokuapp.com")//
				.allowedMethods("GET", "POST", "PUT")//
				.allowedHeaders("Content-Type")//
				.allowCredentials(false)//
				.maxAge(3600);//
	}

}
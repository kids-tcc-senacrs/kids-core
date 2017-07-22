package com.kids;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 05/2017
 * 
 */
@EnableAutoConfiguration
@SpringBootApplication
@EnableJpaRepositories
public class BootApplication {

    public static void main(String[] args) {
	SpringApplication.run(BootApplication.class, args);
    }
}
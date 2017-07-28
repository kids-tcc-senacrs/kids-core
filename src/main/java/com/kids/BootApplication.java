package com.kids;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * @author luciano - lucianoortizsilva@gmail.com
 * @since 05/2017
 * 
 */

@EntityScan(basePackageClasses = { BootApplication.class, Jsr310JpaConverters.class })
@SpringBootApplication
@EnableJpaRepositories
public class BootApplication {

    public static void main(String[] args) {
	SpringApplication.run(BootApplication.class, args);
    }

}
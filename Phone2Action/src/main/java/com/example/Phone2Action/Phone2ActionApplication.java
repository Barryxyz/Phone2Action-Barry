package com.example.Phone2Action;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableAutoConfiguration
@PropertySource(value = "application.properties")
@SpringBootApplication
public class Phone2ActionApplication {

	public static void main(String[] args) {
		SpringApplication.run(Phone2ActionApplication.class, args);
	}

}

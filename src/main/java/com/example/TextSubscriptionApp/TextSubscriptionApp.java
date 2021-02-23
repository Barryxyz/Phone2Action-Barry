package com.example.TextSubscriptionApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableAutoConfiguration
@PropertySource(value = "application.properties")
@SpringBootApplication
public class TextSubscriptionApp {

	public static void main(String[] args) {
		SpringApplication.run(TextSubscriptionApp.class, args);
	}

}

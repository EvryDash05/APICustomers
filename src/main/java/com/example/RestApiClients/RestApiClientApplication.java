package com.example.RestApiClients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//gggggg
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.RestApiClients.repository")
public class RestApiClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiClientApplication.class, args);
	}

}

package com.example.RestApiClients;

import com.example.RestApiClients.DTO.CustomerDTO;
import com.example.RestApiClients.models.Customer;
import com.example.RestApiClients.repository.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.RestApiClients.repository")
public class RestApiClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiClientApplication.class, args);
	}

}

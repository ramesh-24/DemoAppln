package com.company.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.company"})
public class SecurityJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityJdbcApplication.class, args);
	}
}

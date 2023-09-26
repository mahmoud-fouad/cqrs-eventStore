package com.mfouad.cqrs.axonCQRS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.mfouad.cqrs.*")
public class AxonCqrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AxonCqrsApplication.class, args);
	}

}

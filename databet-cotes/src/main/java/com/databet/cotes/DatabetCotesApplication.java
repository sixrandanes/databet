package com.databet.cotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DatabetCotesApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DatabetCotesApplication.class, args);
	}
}

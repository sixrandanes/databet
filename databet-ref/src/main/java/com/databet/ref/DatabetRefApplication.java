package com.databet.ref;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DatabetRefApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DatabetRefApplication.class, args);
	}
}

package com.databet.cotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableDiscoveryClient
@SpringBootApplication
public class DatabetCotesApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DatabetCotesApplication.class, args);
	}
}

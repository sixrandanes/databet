package com.databet.social;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DatabetSocialApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DatabetSocialApplication.class, args);
	}

}

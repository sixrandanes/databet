package com.databet.social;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DatabetEurekaApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DatabetEurekaApplication.class, args);
	}

}

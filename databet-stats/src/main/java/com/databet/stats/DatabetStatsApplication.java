package com.databet.stats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DatabetStatsApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DatabetStatsApplication.class, args);
	}

}

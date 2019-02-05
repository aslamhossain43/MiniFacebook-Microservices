package com.renu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class AboutServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AboutServiceApplication.class, args);
	}

}


package com.renu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class AboutService1Application {

	public static void main(String[] args) {
		SpringApplication.run(AboutService1Application.class, args);
	}

}


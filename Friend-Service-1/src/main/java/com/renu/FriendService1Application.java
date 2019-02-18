package com.renu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class FriendService1Application {

	public static void main(String[] args) {
		SpringApplication.run(FriendService1Application.class, args);
	}

}


package com.renu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
@EnableHystrix
@EnableDiscoveryClient
@SpringBootApplication
public class FriendStockServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FriendStockServiceApplication.class, args);
	}

}

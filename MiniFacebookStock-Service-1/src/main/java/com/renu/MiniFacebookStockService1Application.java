package com.renu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
@EnableHystrix
@EnableDiscoveryClient
@SpringBootApplication
public class MiniFacebookStockService1Application {

	public static void main(String[] args) {
		SpringApplication.run(MiniFacebookStockService1Application.class, args);
	}

}

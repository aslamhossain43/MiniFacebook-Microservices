package com.renu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.netflix.ribbon.proxy.annotation.Hystrix;
@EnableDiscoveryClient
@Hystrix
@SpringBootApplication
public class AboutStockServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AboutStockServiceApplication.class, args);
	}

}


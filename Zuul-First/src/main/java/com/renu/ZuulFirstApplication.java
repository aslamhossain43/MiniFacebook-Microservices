package com.renu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
@EnableDiscoveryClient
@EnableZuulProxy

@SpringBootApplication
public class ZuulFirstApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ZuulFirstApplication.class, args);
		
	}
	
	
}




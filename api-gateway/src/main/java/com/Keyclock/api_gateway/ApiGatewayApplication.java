package com.Keyclock.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		var context=SpringApplication.run(ApiGatewayApplication.class, args);

		System.out.println("DEBUG APP NAME: " + context.getEnvironment().getProperty("spring.application.name"));
	}

}

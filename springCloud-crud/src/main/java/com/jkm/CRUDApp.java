package com.jkm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CRUDApp {
	public static void main(String[] args) {
		SpringApplication.run(CRUDApp.class, args);
		System.out.println("Hello crud!");
	}
}

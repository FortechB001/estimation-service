package com.fortech.estimationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EstimationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstimationServiceApplication.class, args);
	}
}

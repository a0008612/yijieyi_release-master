package com.marry;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableCircuitBreaker
@EnableEurekaClient
@MapperScan(basePackages = {"com.marry.dao"})
public class StudentProviderApplication_1001 {

	public static void main(String[] args) {
		SpringApplication.run(StudentProviderApplication_1001.class, args);
	}
}

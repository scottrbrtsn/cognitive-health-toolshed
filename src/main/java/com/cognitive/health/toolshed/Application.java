package com.cognitive.health.toolshed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages={"com.cognitive.health.toolshed"})
@EnableJpaRepositories
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
public class Application {
    
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}




package com.ykm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // EurekaServer服务器端启动类，接受其他微服务注册进来
@EnableDiscoveryClient // EurekaServer注册发现
@EnableCircuitBreaker
public class DeptProviderHystrix8001_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptProviderHystrix8001_App.class, args);
	}
}

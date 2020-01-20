package com.ykm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class zuul_gateway_9527_App {
	public static void main(String[] args) {
		SpringApplication.run(zuul_gateway_9527_App.class, args);
	}
}

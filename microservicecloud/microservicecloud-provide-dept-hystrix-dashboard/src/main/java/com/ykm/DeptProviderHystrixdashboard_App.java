package com.ykm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DeptProviderHystrixdashboard_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptProviderHystrixdashboard_App.class, args);
	}
}

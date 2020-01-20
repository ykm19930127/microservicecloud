package com.ykm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.cloud.service","com.ykm.springcloud"})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.cloud.service"})//开启使用feign（API项目中的service包的路径）
public class Deptconsimer81_App {

	public static void main(String[] args) {
		SpringApplication.run(Deptconsimer81_App.class, args);		
	}
}

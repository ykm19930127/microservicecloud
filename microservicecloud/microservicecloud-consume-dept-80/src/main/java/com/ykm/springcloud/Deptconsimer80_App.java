package com.ykm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.ykm.myrule.MySelfRule;


@SpringBootApplication
//@EnableDiscoveryClient //EurekaServer注册发现
@EnableEurekaClient
//在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效
@RibbonClient(name="MICROSERVICECLOUD-PROVIDE-DEPT",configuration=MySelfRule.class)
public class Deptconsimer80_App {

	public static void main(String[] args) {
		SpringApplication.run(Deptconsimer80_App.class, args);		
	}
}

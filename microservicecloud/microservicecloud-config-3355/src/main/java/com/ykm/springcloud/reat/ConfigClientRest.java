package com.ykm.springcloud.reat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientRest {
	@Value("${spring.application.name}")
	private String applictionName;
	@Value("${eureka.client.service-url.defaultZone}")
	private String eurekaServers;
	@Value("${server.port}")
	private String port;
	
	@RequestMapping("/config")
	public  String  main(String[] args) {
		String str ="applictionName:"+applictionName+"\t eurekaServers:"+eurekaServers+"\t port:"+port;
		System.out.println("str:+++++++++++++++"+str);
		return str;
	}
}

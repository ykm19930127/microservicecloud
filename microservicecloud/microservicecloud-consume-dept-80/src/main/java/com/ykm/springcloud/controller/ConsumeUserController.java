package com.ykm.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cloud.entry.UserEntry;

@RestController
public class ConsumeUserController {
	
//	private static final String  REST_URL_PREFIX="http://localhost:8001";
	private static final String  REST_URL_PREFIX="http://microservicecloud-provide-dept";
	
	@Autowired
	private RestTemplate restTemplate;

	
	@RequestMapping(value="consumer/user/add")
	public boolean add(UserEntry user){
		return restTemplate.postForObject(REST_URL_PREFIX+"/user/add", user, boolean.class);
	}
	
	@RequestMapping(value="consumer/user/get/{id}")
	public UserEntry get(@PathVariable("id") String id){
		return restTemplate.getForObject(REST_URL_PREFIX+"/user/get/"+id, UserEntry.class);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="consumer/user/list")
	public List<UserEntry> list(){
		return restTemplate.getForObject(REST_URL_PREFIX+"/user/list", List.class);
	}
	
	@RequestMapping(value = "consumer/user/client", method = RequestMethod.GET)
	public Object  getClient() {
		 return restTemplate.getForObject(REST_URL_PREFIX + "/user/client", Object.class);
	 }
}

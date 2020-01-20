package com.ykm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.entry.UserEntry;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ykm.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public boolean add(@RequestBody UserEntry user) {
		return userService.addDept(user);
	}
	@RequestMapping(value = "/user/get/{id}", method = RequestMethod.GET)
	//一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public UserEntry get(@PathVariable("id") Long id)
    {

    	UserEntry dept = this.userService.findById(id);

        if (null == dept) {
            throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
        }

        return dept;
    }


	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public List<UserEntry> list() {
		return userService.findAll();
	}

	@RequestMapping(value = "/user/client", method = RequestMethod.GET)
	public Object getClient() {
		List<String> list = client.getServices();
		System.out.println("**************" + list);

		List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-PROVIDE-DEPT");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}
	
	public UserEntry processHystrix_Get(@PathVariable("id") Long id)
    {
        return new UserEntry().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }

}

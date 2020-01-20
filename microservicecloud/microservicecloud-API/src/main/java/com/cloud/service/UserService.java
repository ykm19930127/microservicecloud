package com.cloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.entry.UserEntry;

/**
*
* @Description: 修改microservicecloud-api工程，根据已经有的DeptClientService接口
新建
一个实现了FallbackFactory接口的类DeptClientServiceFallbackFactory
* @author zzyy
* @date 2018年4月21日
*/

//@FeignClient(value = "MICROSERVICECLOUD-PROVIDE-DEPT")MICROSERVICECLOUD-PROVIDE-DEPT
@FeignClient(value = "MICROSERVICECLOUD-PROVIDE-DEPT",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface  UserService {

    @RequestMapping(value = "/user/get/{id}", method = RequestMethod.GET)
    public UserEntry get(@PathVariable("id") long id);

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public List<UserEntry> list();

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public boolean add(UserEntry dept);
}

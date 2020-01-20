package com.ykm.springcloud.deptController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.entry.UserEntry;
import com.cloud.service.UserService;

@RestController
public class DeptController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/consumer/user/get/{id}")
    public UserEntry get(@PathVariable("id") Long id)
    {
        return this.userService.get(id);
    }

    @RequestMapping(value = "/consumer/user/list")
    public List<UserEntry> list()
    {
        return this.userService.list();
    }

    @RequestMapping(value = "/consumer/user/add")
    public Object add(UserEntry dept)
    {
        return this.userService.add(dept);
    }

}

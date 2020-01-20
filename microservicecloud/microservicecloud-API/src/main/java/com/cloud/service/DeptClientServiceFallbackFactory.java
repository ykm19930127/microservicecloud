package com.cloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cloud.entry.UserEntry;

import feign.hystrix.FallbackFactory;

@Component//一定要加添上去
public class DeptClientServiceFallbackFactory implements FallbackFactory<UserService>{

	@Override
	public UserService create(Throwable arg0) {
		return new UserService() {
			
			@Override
			public List<UserEntry> list() {
				return null;
			}
			
			@Override
			public UserEntry get(long id) {
				return new UserEntry().setDeptno(id).setDname("该ID："+id+"没有对应的信息，Consumer客户端提供的降级信息，此刻服务Provider已经关闭").setDb_source("no this database in MySQL");
			}
			
			@Override
			public boolean add(UserEntry dept) {
				return false;
			}
		};
	}

}

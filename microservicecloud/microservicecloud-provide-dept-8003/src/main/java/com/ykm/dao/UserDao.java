package com.ykm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cloud.entry.UserEntry;


@Mapper
public interface UserDao {
	public boolean addDept(UserEntry user);

	public UserEntry findById(Long id);

	public List<UserEntry> findAll();
}

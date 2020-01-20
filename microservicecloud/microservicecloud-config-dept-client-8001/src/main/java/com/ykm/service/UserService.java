package com.ykm.service;

import java.util.List;

import com.cloud.entry.UserEntry;



public interface UserService {
	public boolean addDept(UserEntry user);

	public UserEntry findById(Long id);

	public List<UserEntry> findAll();
}

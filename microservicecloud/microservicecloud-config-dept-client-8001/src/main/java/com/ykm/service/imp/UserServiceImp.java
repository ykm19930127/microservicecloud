package com.ykm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.entry.UserEntry;
import com.ykm.dao.UserDao;
import com.ykm.service.UserService;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean addDept(UserEntry user) {
		return userDao.addDept(user);
	}

	@Override
	public UserEntry findById(Long id) {
		return userDao.findById(id);
	}

	@Override
	public List<UserEntry> findAll() {
		return userDao.findAll();
	}

}

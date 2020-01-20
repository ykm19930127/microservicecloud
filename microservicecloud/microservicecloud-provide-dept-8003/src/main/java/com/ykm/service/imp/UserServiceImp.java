package com.ykm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.entry.UserEntry;
import com.ykm.dao.UserDao;
import com.ykm.service.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userdao;

	@Override
	public boolean addDept(UserEntry user) {
		return userdao.addDept(user);
	}

	@Override
	public UserEntry findById(Long id) {
		return userdao.findById(id);
	}

	@Override
	public List<UserEntry> findAll() {
		return userdao.findAll();
	}

}

package com.hcl.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.dao.UserDao;
import com.hcl.model.Login;
import com.hcl.model.User;

public class UserServiceImpl implements UserService{
	
	@Autowired
	public UserDao userDao;

	@Override
	public int register(User user) {
		return userDao.register(user);
	}

	@Override
	public User validateUser(Login login) {
		
		return userDao.validateUser(login);
	}

}

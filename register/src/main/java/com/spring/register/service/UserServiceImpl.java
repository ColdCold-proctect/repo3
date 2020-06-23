package com.spring.register.service;

import com.spring.register.dao.UserDao;
import com.spring.register.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public Integer registerAll(User user) {
		return userDao.registerAll(user);
	}

	@Override
	public User checkUser(String username, String password) {
		User user= userDao.checkup(username,password);
		return user;
	}
}

package com.spring.register.service;


import com.spring.register.pojo.User;

public interface UserService {
	Integer registerAll(User user);
	User checkUser(String username,String password);
}

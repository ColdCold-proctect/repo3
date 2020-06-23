package com.spring.register.dao;


import com.spring.register.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
	User checkup(String username,String password);
	Integer registerAll(User user);
}

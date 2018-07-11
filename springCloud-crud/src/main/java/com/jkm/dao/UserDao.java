package com.jkm.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jkm.entity.User;

/*********************************************
 * UserDao.java Author: jkbao Created on: 2018年7月9日
 ********************************************/
@Component
public interface UserDao {

	User findUser(int id);

	List<User> findUserList();

	int add(User user);

	int delete(int id);

	int update(User user);
}

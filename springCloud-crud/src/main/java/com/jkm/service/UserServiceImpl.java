package com.jkm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jkm.dao.UserDaoImpl;
import com.jkm.entity.User;

/*********************************************
 * UserService.java Author: jkbao Created on: 2018年7月9日
 ********************************************/
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDaoImpl userDaoImpl;

	@Override
	public User findUser(int id) {
		return userDaoImpl.findUser(id);
	}

	@Override
	public List<User> findUserList() {
		return userDaoImpl.findUserList();
	}

	@Override
	public int add(User user) {
		return userDaoImpl.add(user);
	}

	@Override
	public int delete(int id) {
		return userDaoImpl.delete(id);
	}

	@Override
	public int update(User user) {
		return userDaoImpl.update(user);
	}
}

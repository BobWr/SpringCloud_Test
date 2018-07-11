/*********************************************
 * UserService.java
 * Author: bjk
 * Created on: 2018年7月9日
 ********************************************/
/**
 *
 */
package com.jkm.service;

import java.util.List;

import com.jkm.entity.User;

/*********************************************
 * UserService.java Author: jkbao Created on: 2018年7月9日
 ********************************************/
public interface UserService {

	User findUser(int id);

	List<User> findUserList();

	int add(User user);

	int delete(int id);

	int update(User user);

}

package com.jkm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jkm.entity.User;
import com.jkm.service.UserServiceImpl;

/*********************************************
 * CRUDController.java Author: jkbao Created on: 2018年7月9日
 ********************************************/
@RestController
@RequestMapping("/crud/user")
public class UserController {

	@Autowired
	UserServiceImpl userService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable("id") int id, HttpServletRequest request) {
		User user = userService.findUser(id);
		if (user == null) {
			throw new RuntimeException("没有此用户");
		}
		//System.out.println("1");
		return user;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Map<String, Object> getUserList(HttpServletRequest request) {

		List<User> userList = userService.findUserList();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("total", userList.size());
		param.put("rows", userList);
		return param;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void add(@Valid @RequestBody User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.getFieldError().getDefaultMessage());
		}
		
		try {
			userService.add(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(method = RequestMethod.PUT)
	public void update(@RequestBody User user) {
		try {
			userService.update(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		try {
			this.userService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@RequestMapping(method = RequestMethod.POST)
//	public void add(@Valid @RequestBody Map<String, Object> request, BindingResult bindingResult) {
//		if (bindingResult.hasErrors()) {
//			System.out.println(bindingResult.getFieldError().getDefaultMessage());
//		}
//		String id = (String) request.get("id");
//		String username = (String) request.get("username");
//		String password = (String) request.get("password");
//		User user = new User();
//		if (user != null) {
//			user.setId(Integer.valueOf(id));
//		}
//		user.setUsername(username);
//		user.setPassword(password);
//		try {
//			userService.add(user);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//	public void update(@PathVariable("id") int id, @RequestBody Map<String, Object> request) {
//		User user = userService.findUser(id);
//		String username = (String) request.get("username");
//		String password = (String) request.get("password");
//		user.setUsername(username);
//		user.setPassword(password);
//		try {
//			userService.update(user);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}

package com.jkm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jkm.entity.User;

/*********************************************
 * RestController.java Author: jkbao Created on: 2018年7月9日
 ********************************************/
@RestController
@RequestMapping(value = "/crud")
public class CRUDController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
	public String getUser(@PathVariable("id") int id, HttpServletRequest request) {
		return restTemplate.getForObject("http://SERVICE-CRUD/crud/user/" + id, String.class);
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
	public String getUserList(HttpServletRequest request) {
		return restTemplate.getForObject("http://SERVICE-CRUD/crud/user/", String.class);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json")
	public String addUser(@Valid @RequestBody User user, BindingResult bindingResult ,
			HttpServletRequest request) {
		ResponseEntity<String> responseEntity =  restTemplate.postForEntity(
				"http://SERVICE-CRUD/crud/user/", user, String.class);
		
		return responseEntity.getBody();
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public void update(@Valid @RequestBody User user, BindingResult bindingResult ,
			HttpServletRequest request) {
		restTemplate.put("http://SERVICE-CRUD/crud/user/", user);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id, HttpServletRequest request) {
		restTemplate.delete("http://SERVICE-CRUD/crud/user/" + id);
	}
}

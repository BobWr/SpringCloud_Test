package com.jkm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jkm.entity.User;

/*********************************************
 * UserDaoJdbcTemplateImpl.java Author: jkbao Created on: 2018年7月9日
 ********************************************/
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User findUser(int id) {

		String sql = "select * from user where id=?";

		List<User> list = jdbcTemplate.query(sql, new Object[] { id }, new BeanPropertyRowMapper<User>(User.class));

		if (null != list && list.size() > 0) {
			User user = list.get(0);
			return user;
		} else {
			return null;
		}
	}

	@Override
	public List<User> findUserList() {

		String sql = "select * from user";

		List<User> list = jdbcTemplate.query(sql, new Object[] {}, new BeanPropertyRowMapper<User>(User.class));

		return list;
	}

	@Override
	public int add(User user) {

		String sql = "insert into user(id,username,password) values(?,?,?)";

		return jdbcTemplate.update(sql, user.getId(), user.getUsername(), user.getPassword());
	}

	@Override
	public int delete(int id) {
		String sql = "delete from user where id = ?";

		return jdbcTemplate.update(sql, id);
	}

	@Override
	public int update(User user) {

		String sql = "update user set id=?,username=? ,password=? where username = ?";

		return jdbcTemplate.update(sql, user.getId(), user.getUsername(), user.getPassword(), user.getUsername());
	}
}

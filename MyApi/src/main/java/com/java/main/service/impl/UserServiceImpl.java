package com.java.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.main.Dao.UserDao;
import com.java.main.entity.Users;
import com.java.main.service.UserService;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;

	@Override
	public Users login(String username, String password) {
		Users users = new Users();
		users.getUsername();
		Users users1 = dao.findByUsernameAndPassword(username, password);
		if (users1 != null) {
			return users1;
		}
		return users;
	}

}

package com.java.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.main.entity.Users;
import com.java.main.service.UserService;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping(value = "/login/{username}/{password}")
	public Users login(@PathVariable("username") String username,@PathVariable("password") String password) {
		return service.login(username, password);
	}
}

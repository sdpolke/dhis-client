package com.ezest.dhis2.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ezest.dhis2.portal.model.User;
import com.ezest.dhis2.portal.service.UserService;

@RequestMapping(value = "users")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/{uid}")
	public User getUser(@PathVariable String uid) {
		return userService.getUser(uid);
	}
	
	@PostMapping("/create")
	public String createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
}

package com.ezest.dhis2.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezest.dhis2.portal.model.User;
import com.ezest.dhis2.portal.model.UserDto;
import com.ezest.dhis2.portal.service.UserService;

import io.swagger.annotations.Api;

@Api(value="User Controller", tags = "User" )
@RequestMapping(value = "users")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{uid}")
	public User getUser(@PathVariable String uid) {
		return userService.getUser(uid);
	}
	
	@PostMapping("/create")
	public String createUser(@RequestBody UserDto user) {
		return userService.createUser(user);
	}

}

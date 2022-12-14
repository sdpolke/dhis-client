package com.ezest.dhis2.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezest.dhis2.portal.model.UserRole;
import com.ezest.dhis2.portal.service.UserRoleService;

import io.swagger.annotations.Api;

@Api(value="UserRole Controller", tags = "UserRole" )
@RequestMapping(value = "userRoles")
@RestController
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;
	
	@GetMapping
	public List<UserRole> getAllUserRoles() {
		return userRoleService.getAllUserRoles();
	}

	@GetMapping("/{uid}")
	public UserRole getUserRole(@PathVariable String uid) {
		return userRoleService.getUserRole(uid);
	}
}

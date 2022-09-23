package com.ezest.dhis2.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezest.dhis2.portal.model.UserGroup;
import com.ezest.dhis2.portal.service.UserGroupService;

import io.swagger.annotations.Api;

@Api(value="UserGroup Controller", tags = "UserGroup" )
@RequestMapping(value = "userGroups")
@RestController
public class UserGroupController {
    
	@Autowired
    private UserGroupService userGroupService;

    @GetMapping
    public List<UserGroup> getUserGroups() {
        return userGroupService.getUserGroups();
    }

    @GetMapping("/{uid}")
	public UserGroup getUserGroup(@PathVariable String uid) {
    	return userGroupService.getUserGroup(uid);
	}
}

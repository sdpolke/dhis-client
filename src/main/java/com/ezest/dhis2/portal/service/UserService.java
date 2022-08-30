package com.ezest.dhis2.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezest.dhis2.portal.adapter.UserAdapter;
import com.ezest.dhis2.portal.model.User;

import lombok.extern.slf4j.Slf4j;

//TODO Add validation for Request

@Slf4j
@Service
public class UserService {

	@Autowired
	private UserAdapter userAdapter;
	
	public String createUser(User user) {
		log.debug("Creating User...");
		return userAdapter.createUser(user);
	}

	public User getUser(String uuid) {
		log.debug("Getting User with ID: " + uuid) ;
		return userAdapter.getUser(uuid);
	}

	public List<User> getAllUsers() {
		log.debug("Getting All Users...") ;
		return userAdapter.getAllUsers();
	}

}

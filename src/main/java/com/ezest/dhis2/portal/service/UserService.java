package com.ezest.dhis2.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezest.dhis2.portal.adapter.UserAdapter;
import com.ezest.dhis2.portal.model.User;

@Service
public class UserService {

	@Autowired
	private UserAdapter userAdapter;
	
	public String createUser(User user) {
		return userAdapter.createUser(user);
	}

	public User getUser(String uuid) {
		return userAdapter.getUser(uuid);
	}

}

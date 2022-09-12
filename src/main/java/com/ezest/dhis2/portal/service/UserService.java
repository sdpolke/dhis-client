package com.ezest.dhis2.portal.service;

import java.util.List;

import org.hisp.dhis.query.Query;
import org.hisp.dhis.response.object.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezest.dhis2.portal.adapter.UserAdapter;
import com.ezest.dhis2.portal.config.PortalConfig;
import com.ezest.dhis2.portal.model.User;

import lombok.extern.slf4j.Slf4j;

//TODO Add validation for Request

@Slf4j
@Service
public class UserService {

	@Autowired
	private PortalConfig portalConfig;
	
	@Autowired
	private UserAdapter userAdapter;
	
	public String createUser(User user) {
		log.debug("Creating User...");
//		ObjectResponse res = portalConfig.getPortalDhis2().saveMetadataObject("users", user);
//		System.err.println(res.toString());
//		return res.getStatus().name();
		return userAdapter.createUser(user);
	}

	public User getUser(String uuid) {
		log.debug("Getting User with ID: " + uuid) ;
		return portalConfig.getPortalDhis2().getObject("users", uuid, User.class);
	}

	public List<User> getAllUsers() {
		log.debug("Getting All Users...") ;
		return portalConfig.getPortalDhis2().getUsers(Query.instance());
	}

}

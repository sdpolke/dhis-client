package com.ezest.dhis2.portal.adapter;

import java.util.Objects;

import org.hisp.dhis.response.Status;
import org.hisp.dhis.response.object.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.ezest.dhis2.portal.config.PortalConfig;
import com.ezest.dhis2.portal.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserAdapter {

	@Autowired
	PortalConfig config;

	public String createUser(User user) {
		HttpEntity<User> request = new HttpEntity<>(user);
		ResponseEntity<ObjectResponse> userResponse = config.restTemplate().exchange(config.userEndpoint(),
				HttpMethod.POST, request, ObjectResponse.class);
		
		if(!isSucceed(userResponse.getBody())) {
			log.error("Create User call failed.");
			throw new RuntimeException("Create User call failed.");
		}
		
		System.out.println(Objects.toString(userResponse.getBody()));
		
		return userResponse.getBody().getResponse().getUid();

	}
	
	private boolean isSucceed(ObjectResponse objectResponse) {
		return Status.OK == objectResponse.getStatus();
		
	}

	public User getUser(String uuid) {
		String effectiveUrl = config.getUserEndpointUrl() + "/" + uuid;

		String userResponse = config.restTemplate().getForObject(effectiveUrl, String.class, uuid);

		User user = null;
		String format = "yyyy-MM-dd'T'hh:mm:ss.SSS";
		try {
			Gson gson = new GsonBuilder().setDateFormat(format).create();
			user = gson.fromJson(userResponse, User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(Objects.toString(userResponse));
		System.out.println(Objects.toString(user));

		return user;
	}

}

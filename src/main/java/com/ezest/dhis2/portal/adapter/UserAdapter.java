package com.ezest.dhis2.portal.adapter;

import java.util.List;
import java.util.Objects;

import org.hisp.dhis.response.Status;
import org.hisp.dhis.response.object.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import com.ezest.dhis2.portal.config.PortalConfig;
import com.ezest.dhis2.portal.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserAdapter {

	private static final String USER_DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ss.SSS";
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
		try {
			Gson gson = new GsonBuilder().setDateFormat(USER_DATE_FORMAT).create();
			user = gson.fromJson(userResponse, User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(Objects.toString(userResponse));
		System.out.println(Objects.toString(user));

		return user;
	}

	public List<User> getAllUsers() {
		ResponseEntity<List<String>> userResponse = null;
		String res = null;
		try {
//			userResponse = config.restTemplate().exchange(config.getUserEndpointUrl(),
//					HttpMethod.GET, HttpEntity<JsonObject>.class, null);
			res = config.restTemplate().getForObject(config.getUserEndpointUrl(), String.class, "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//List<String> users = userResponse.getBody();

		System.out.println(Objects.toString(res));

		List<User> users = null;
		try {
			Gson gson = new GsonBuilder().setDateFormat(USER_DATE_FORMAT).create();
			//users = gson.fromJson(userResponse, List<User>.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 

		//System.out.println(Objects.toString(user));
		
		return null;
	}

}

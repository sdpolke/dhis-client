package com.ezest.dhis2.portal;

import java.util.Date;
import java.util.UUID;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezest.dhis2.portal.controller.UserController;
import com.ezest.dhis2.portal.model.User;
import com.ezest.dhis2.portal.model.UserRole;

@SpringBootTest
class Dhis2PortalApplicationTests {

	
	@Autowired
	UserController userController;
	
	@Test
	void contextLoads() {
		System.out.println("Context Loads successfully.....");
	}
	
	@Test
	void testGetUser() {
		String userUuid = "DLjZWMsVsq2";
		User user = userController.getUser(userUuid);
		Assert.assertNotNull(user);
		System.err.println(user.getFirstName());
		
	}
	
	@Test
	void testCreateUser() {
		User user = new User();
		user.setUuid(UUID.randomUUID());
		user.setUsername("somnath.k");
		user.setFirstName("somnath");
		user.setSurname("Test");
		user.setPassword("Test123*");
		user.setCreated(new Date(System.currentTimeMillis()));
		
		UserRole role = new UserRole();
		role.setId("Ufph3mGRmMo");
		
		user.getUserRoles().add(role);
		
		String uuid = userController.createUser(user);
		Assert.assertNotNull(uuid);
		System.err.println("Created USER UUID: " + uuid);
		
	}

}

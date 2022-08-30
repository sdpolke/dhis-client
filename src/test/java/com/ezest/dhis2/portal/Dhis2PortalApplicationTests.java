package com.ezest.dhis2.portal;

import com.ezest.dhis2.portal.controller.ProgramController;
import com.ezest.dhis2.portal.controller.UserController;
import com.ezest.dhis2.portal.model.User;
import com.ezest.dhis2.portal.model.UserRole;
import org.hisp.dhis.model.Program;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class Dhis2PortalApplicationTests {

	
	@Autowired
	UserController userController;
	
	@Autowired
	ProgramController programController;
	
	@Test
	void contextLoads() {
		System.out.println("Context Loads successfully.....");
	}
	
	@Test
	void testGetPrograms() {
		List<Program> programs = programController.getAllPrograms();

		assertNotNull(programs);
		assertFalse(programs.isEmpty());
		assertNotNull(programs.get(0));
	}
	
	@Test
	void testGetProgram() {
		Program program = programController.getProgram("IpHINAT79UW");
		System.err.println(program.toString());
		assertNotNull(program);
	}
	
	//@Test
	void testGetAllUsers() {
		List<User> users = userController.getAllUsers();
		Assert.assertNotNull(users);
		System.err.println(users.size());
		
	}
	
	@Test
	void testGetUser() {
		String userUuid = "DLjZWMsVsq2";
		User user = userController.getUser(userUuid);
		Assert.assertNotNull(user);
		System.err.println(user.getFirstName());
		
	}
	
	//@Test
	void testCreateUser() {
		User user = new User();
		user.setUuid(UUID.randomUUID());
		user.setUsername("UserSomnath");
		user.setFirstName("Somnath");
		user.setSurname("Kardak");
		user.setPassword("Somnath*");
		user.setCreated(new Date(System.currentTimeMillis()));
		
		UserRole role = new UserRole();
		role.setId("Ufph3mGRmMo");
		
		user.getUserRoles().add(role);
		
		String uuid = userController.createUser(user);
		Assert.assertNotNull(uuid);
		System.err.println("Created USER UUID: " + uuid);
		
	}

}

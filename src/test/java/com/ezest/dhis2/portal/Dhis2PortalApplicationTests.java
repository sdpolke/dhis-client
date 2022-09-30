package com.ezest.dhis2.portal;

import com.ezest.dhis2.portal.controller.*;
import com.ezest.dhis2.portal.model.*;
import org.hisp.dhis.model.DataElement;
import org.hisp.dhis.model.OrgUnit;
import org.hisp.dhis.model.PeriodType;
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
	@Autowired
	OrgUnitController orgUnitController;
	@Autowired
	UserRoleController userRoleController;
	@Autowired
	DataSetController dataSetController;
	@Autowired
	UserGroupController userGroupController;
	@Autowired
	DataElementController dataElementController;
	@Autowired
	CompletionPercentCalculatorController percentCalculatorController;
	
	@Test
	void contextLoads() {
		System.out.println("Context Loads successfully.....");
	}
	
	@Test
	void testCalculatePercent() {
		CompletionPercentageCalculatorReq req = new CompletionPercentageCalculatorReq();
		req.setDataSetId("BfMAe6Itzgt");
		req.setDate("2022-01");
		req.setOUId("DiszpKrYNg8");
		
		String percent = percentCalculatorController.calculatePercentageOfCompletion(req);
		System.err.println(percent);
		
		
	}
	
	@Test
	void testGetUserGroups() {
		List<UserGroup> userGroups = userGroupController.getUserGroups();

		assertNotNull(userGroups);
		assertFalse(userGroups.isEmpty());
		assertNotNull(userGroups.get(0));
		System.err.println(userGroups.size());
	}
	
	@Test
	void testGetUserGroup() {
		UserGroup userGroup = userGroupController.getUserGroup("ZoHNWQajIoe");

		assertNotNull(userGroup);
		System.err.println(userGroup.toString());
	}
	
	//@Test
	void testCreateDataSet() {
		DataSet dataSet = new DataSet();
		dataSet.setName("Regular flu");
		
		PeriodType periodType = new PeriodType();
		periodType.setName("Quarterly");
		
		//dataSet.setPeriodType(periodType);
		
		CategoryCombo categoryCombo = new CategoryCombo();
		categoryCombo.setId("1452089");
		
		dataSet.setCategoryCombo(categoryCombo);
		
		dataSetController.saveDataSet(dataSet);
		
		System.err.println(dataSet.getId());
		assertNotNull(dataSet.getId());
	}
	
	@Test
	void testGetDataElements() {
		List<DataElement> dataElements = dataElementController.getAllDataElements();

		assertNotNull(dataElements);
		assertFalse(dataElements.isEmpty());
		assertNotNull(dataElements.get(0));
		System.err.println(dataElements.get(0).toString());
		System.err.println(dataElements.size());
	}
	
	@Test
	void testGetDataElement() {
		DataElement dataElement = dataElementController.getDataElement("FTRrcoaog83");
		System.err.println(dataElement.toString());
		assertNotNull(dataElement);
	}
	
	@Test
	void testGetDataSets() {
		List<DataSet> dataSets = dataSetController.getAllDataSets();

		assertNotNull(dataSets);
		assertFalse(dataSets.isEmpty());
		assertNotNull(dataSets.get(0));
		System.err.println(dataSets.size());
	}
	
	@Test
	void testGetDataSet() {
		DataSet dataSet = dataSetController.getDataSet("Lpw6GcnTrmS");
		System.err.println(dataSet.toString());
		assertNotNull(dataSet);
	}
	
	@Test
	void testGetUserRoles() {
		List<UserRole> userRoles = userRoleController.getAllUserRoles();

		assertNotNull(userRoles);
		assertFalse(userRoles.isEmpty());
		assertNotNull(userRoles.get(0));
		System.err.println(userRoles.get(0));
	}
	
	@Test
	void testGetUserRole() {
		UserRole userRole = userRoleController.getUserRole("LGWLyWNro4x");
		System.err.println(userRole.toString());
		assertNotNull(userRole);
	}
	
	
	@Test
	void testGetOrgUnits() {
		List<OrgUnit> orgUnits = orgUnitController.getAllOrgUnits();

		assertNotNull(orgUnits);
		assertFalse(orgUnits.isEmpty());
		assertNotNull(orgUnits.get(0));
		System.err.println(orgUnits.get(0));
	}
	
	
	@Test
	void testGetOrgUnit() {
		OrgUnit orgUnit = orgUnitController.getOrgUnit("Rp268JB6Ne4");
		System.err.println(orgUnit.toString());
		assertNotNull(orgUnit);
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
	
	@Test
	void testGetProgramMetadata() {
		Program program = programController.getProgram("IpHINAT79UW");
		System.err.println(program.toString());
		assertNotNull(program);
	}
	
	@Test
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
	
	@Test
	void testCreateUser() {
		UserDto user = new UserDto();
		user.setId(String.valueOf(UUID.randomUUID()));
		user.setUuid(UUID.randomUUID());
		user.setUsername("shri" + Math.random());
		user.setFirstName("Shri");
		user.setSurname("Ezest");
		user.setPassword("Test123#@");
		user.setCreated(new Date(System.currentTimeMillis()));
		
		UserRole role = new UserRole();
		role.setId("Ufph3mGRmMo");
		
		user.getUserRoles().add(role);
		
		UserCredentialsDto credential = new UserCredentialsDto();
		credential.setId(String.valueOf(UUID.randomUUID()));
		UserInfo userInfo = new UserInfo();
		userInfo.setId(user.getId());
		credential.setUserInfo(userInfo);
		credential.setUsername(user.getUsername());
		credential.setPassword(user.getPassword());
		credential.setUserRoles(user.getUserRoles());
		
		user.setUserCredentials(credential);
		
		String uuid = userController.createUser(user);
		Assert.assertNotNull(uuid);
		System.err.println("Created USER UUID: " + uuid);
		
	}

}

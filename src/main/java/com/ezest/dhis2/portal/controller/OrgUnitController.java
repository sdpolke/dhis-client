package com.ezest.dhis2.portal.controller;

import java.util.List;

import org.hisp.dhis.model.OrgUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezest.dhis2.portal.service.OrgUnitService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "OrgUnit Controller", tags = "OrgUnit")
@RequestMapping(value = "orgUnits")
@RestController
public class OrgUnitController {

	@Autowired
	private OrgUnitService orgUnitService;

	@ApiOperation(value = "View a list of available OrgUnits", response = Iterable.class, tags = "Get all OrgUnits", nickname = "getAllOrgUnitsUsingGET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved OrgUnits"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping
	public List<OrgUnit> getAllOrgUnits() {
		return orgUnitService.getAllOrgUnits();
	}

	@ApiOperation(value = "View a OrgUnit by given UID", response = OrgUnit.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved OrgUnit"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/{uid}")
	public OrgUnit getOrgUnit(@PathVariable String uid) {
		return orgUnitService.getOrgUnit(uid);
	}
}

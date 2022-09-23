package com.ezest.dhis2.portal.controller;

import java.util.List;

import org.hisp.dhis.model.OrgUnitGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezest.dhis2.portal.service.OrgUnitGroupService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="OrgUnitGroup Controller", tags = "OrgUnitGroup" )
@RequestMapping(value = "orgUnitGroups")
@RestController
public class OrgUnitGroupController {

	@Autowired
	private OrgUnitGroupService orgUnitGroupService;

	@ApiOperation(value = "View a list of available OrgUnits",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved OrgUnits"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@GetMapping
	public List<OrgUnitGroup> getAllOrgUnitGroups() {
		return orgUnitGroupService.getAllOrgUnitGroups();
	}

	@ApiOperation(value = "View a OrgUnitGroup by given UID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved OrgUnitGroup"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@GetMapping("/{uid}")
	public OrgUnitGroup getOrgUnitGroup(@PathVariable String uid) {
		return orgUnitGroupService.getOrgUnitGroup(uid);
	}
}

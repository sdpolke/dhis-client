package com.ezest.dhis2.portal.controller;

import java.util.List;

import org.hisp.dhis.model.OrgUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezest.dhis2.portal.service.OrgUnitService;

@RequestMapping(value = "orgUnits")
@RestController
public class OrgUnitController {

	@Autowired
	private OrgUnitService orgUnitService;
	
	@GetMapping
	public List<OrgUnit> getAllOrgUnits() {
		return orgUnitService.getAllOrgUnits();
	}

	@GetMapping("/{uid}")
	public OrgUnit getOrgUnit(@PathVariable String uid) {
		return orgUnitService.getOrgUnit(uid);
	}
}

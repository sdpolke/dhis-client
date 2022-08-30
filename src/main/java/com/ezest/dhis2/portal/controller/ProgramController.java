package com.ezest.dhis2.portal.controller;

import java.util.List;

import org.hisp.dhis.model.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezest.dhis2.portal.model.User;
import com.ezest.dhis2.portal.service.ProgramService;
import com.ezest.dhis2.portal.service.UserService;

@RequestMapping(value = "programs")
@RestController
public class ProgramController {

	@Autowired
	private ProgramService programService;

	@GetMapping
	public List<Program> getAllPrograms() {
		return programService.getAllPrograms();
	}
	
	@GetMapping("/{uid}")
	public Program getProgram(@PathVariable String uid) {
		return programService.getProgram(uid);
	}
}

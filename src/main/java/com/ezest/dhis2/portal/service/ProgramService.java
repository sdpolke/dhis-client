package com.ezest.dhis2.portal.service;

import java.util.List;
import java.util.Objects;

import org.hisp.dhis.model.Program;
import org.hisp.dhis.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezest.dhis2.portal.config.PortalConfig;

@Service
public class ProgramService {

	@Autowired
	private PortalConfig portalConfig;
	
	public List<Program> getAllPrograms() {
		List<Program> programs = portalConfig.getDhis2().getPrograms(Query.instance());
		//TODO Add required CUSTOM logic here
		return programs;
	}

	public Program getProgram(String uid) {
		Program program = portalConfig.getDhis2().getProgram(uid);
		System.err.println(Objects.toString(program));
		return program;
	}

}

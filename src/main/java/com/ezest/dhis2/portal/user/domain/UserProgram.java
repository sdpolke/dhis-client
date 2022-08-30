package com.ezest.dhis2.portal.user.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserProgram {

	private String uid;
	private int id;
	
	private String name;
	private String cycleName;
	private LocalDate startDate;
	private LocalDate endDate; //aka expiryDate
	private ProgramStatus status;
	
	//private TrackedProgram trackedEntity;
	//private UserOrgUnit userOrg;
	private long numberOfUsers;
	private boolean complete;
	
	
	public enum ProgramStatus {
		DRAFT,
		ACTIVE,
		CLOSED
	}
	
}

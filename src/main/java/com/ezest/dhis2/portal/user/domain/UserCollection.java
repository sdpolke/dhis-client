package com.ezest.dhis2.portal.user.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

/**
 * Collections of Programs created by Portal User.
 * This is statistics of different program and its metadata.
 * This DOMAIN classes will be used in Portal UI.
 * 
 * Some of the details of this POJO will be stored in PORTAL DB
 * and others will be fetched from DHIS2 API from WHO instance.
 */
@Getter
@Setter
public class UserCollection {

	private int collectionId;
	private String collectionName;
	private Set<UserProgram> programs = new HashSet<>();
	private float overallCompletionPercent;
	private LocalDate createdDate;
	private LocalDate expiryDate;

}

package com.ezest.dhis2.portal.model;

import java.util.HashSet;
import java.util.Set;

import org.hisp.dhis.model.NameableObject;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRole extends NameableObject {
	
	public static final String AUTHORITY_ALL = "ALL";
	
	/*
	 * @JsonProperty private String id;
	 * 
	 * @JsonProperty private String description;
	 */
	
	@JsonProperty
	private Set<String> authorities = new HashSet<>();
	
	//TODO check why this is not returned by API call
	//@JsonProperty
	//private Set<User> members = new HashSet<>();

}

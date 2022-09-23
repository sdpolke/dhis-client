package com.ezest.dhis2.portal.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo {

	@JsonProperty
	private String id;
}

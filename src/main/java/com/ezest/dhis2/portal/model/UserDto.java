package com.ezest.dhis2.portal.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto extends User {

	@JsonProperty
	private UserCredentialsDto userCredentials;
}

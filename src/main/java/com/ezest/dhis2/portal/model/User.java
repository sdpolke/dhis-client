package com.ezest.dhis2.portal.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.hisp.dhis.model.Category;
import org.hisp.dhis.model.CategoryOptionGroupSet;
import org.hisp.dhis.model.IdentifiableObject;
import org.hisp.dhis.model.OrgUnit;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User extends IdentifiableObject implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty
	private UUID uuid;

	@JsonProperty
	private String displayName;

	@JsonProperty
	private String username;

	private boolean externalAuth;

	@JsonProperty
	private String openId;

	@JsonProperty
	private String ldapId;

	@JsonProperty
	private String password;

	@JsonProperty
	private boolean twoFA;

	@JsonProperty
	private String secret;

	@JsonProperty
	private Date passwordLastUpdated;

	@JsonProperty
	private Set<UserRole> userRoles = new HashSet<>();

	@JsonProperty
	private Date accountExpiry;

	@JsonProperty
	private String surname;

	@JsonProperty
	private String firstName;

	@JsonProperty
	private String email;

	@JsonProperty
	private String phoneNumber;

	@JsonProperty
	private String jobTitle;

	@JsonProperty
	private String introduction;

	@JsonProperty
	private String gender;

	@JsonProperty
	private Date birthday;

	@JsonProperty
	private String nationality;

	@JsonProperty
	private String employer;

	@JsonProperty
	private String education;

	@JsonProperty
	private String interests;

	@JsonProperty
	private String languages;

	@JsonProperty
	private String welcomeMessage;

	@JsonProperty
	private Date lastCheckedInterpretations;

	@JsonProperty
	private Set<UserGroup> groups = new HashSet<>();

	@JsonProperty
	private String whatsApp;

	@JsonProperty
	private String facebookMessenger;

	@JsonProperty
	private String skype;

	@JsonProperty
	private String telegram;

	@JsonProperty
	private String twitter;

	@JsonProperty
	private Set<OrgUnit> organisationUnits = new HashSet<>();

}

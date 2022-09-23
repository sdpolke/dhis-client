/*
 * Copyright (c) 2004-2022, University of Oslo
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * Neither the name of the HISP project nor the names of its contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.ezest.dhis2.portal.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserGroup {
	
	@JsonProperty
	public static final String AUTH_USER_ADD = "F_USER_ADD";
	@JsonProperty
	public static final String AUTH_USER_DELETE = "F_USER_DELETE";
	@JsonProperty
	public static final String AUTH_USER_VIEW = "F_USER_VIEW";
	@JsonProperty
	public static final String AUTH_USER_ADD_IN_GROUP = "F_USER_ADD_WITHIN_MANAGED_GROUP";
	@JsonProperty
	public static final String AUTH_ADD_MEMBERS_TO_READ_ONLY_USER_GROUPS = "F_USER_GROUPS_READ_ONLY_ADD_MEMBERS";
	
	@JsonProperty
	private String name;

	/**
	 * Global unique identifier for UserGroup (to be used for sharing etc)
	 */
	@JsonProperty
	private UUID uuid;

	/**
	 * Set of related users
	 */
	@JsonProperty
	private Set<User> members = new HashSet<>();

	/**
	 * User groups (if any) that members of this user group can manage the members
	 * within.
	 */
	@JsonProperty
	private Set<UserGroup> managedGroups = new HashSet<>();

	/**
	 * User groups (if any) whose members can manage the members of this user group.
	 */
	@JsonProperty
	private Set<UserGroup> managedByGroups = new HashSet<>();

	public UserGroup(String name) {
		this.name = name;
	}

	public UserGroup(String name, Set<User> members) {
		this(name);
		this.members = members;
	}

	// -------------------------------------------------------------------------
	// Getters and setters
	// -------------------------------------------------------------------------
	@JsonProperty
	public UUID getUuid() {
		return uuid;
	}

	@JsonProperty
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	@JsonProperty("users")
	// @JsonSerialize( contentUsing = UserPropertyTransformer.JacksonSerialize.class
	// )
	// @JsonDeserialize( contentUsing =
	// UserPropertyTransformer.JacksonDeserialize.class )
	// @PropertyTransformer( UserPropertyTransformer.class )
	public Set<User> getMembers() {
		return members;
	}

	public void setMembers(Set<User> members) {
		this.members = members;
	}

	@JsonProperty("managedGroups")
	// @JsonSerialize( contentAs = BaseIdentifiableObject.class )
	public Set<UserGroup> getManagedGroups() {
		return managedGroups;
	}

	public void setManagedGroups(Set<UserGroup> managedGroups) {
		this.managedGroups = managedGroups;
	}

	@JsonProperty("managedByGroups")
	// @JsonSerialize( contentAs = BaseIdentifiableObject.class )
	public Set<UserGroup> getManagedByGroups() {
		return managedByGroups;
	}

	@JsonProperty
	public void setManagedByGroups(Set<UserGroup> managedByGroups) {
		this.managedByGroups = managedByGroups;
	}
}

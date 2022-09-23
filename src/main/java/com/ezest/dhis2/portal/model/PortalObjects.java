package com.ezest.dhis2.portal.model;

import java.util.ArrayList;
import java.util.List;

import org.hisp.dhis.model.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class PortalObjects extends Objects {

	@JsonProperty
    private List<User> users = new ArrayList<>();
	
	@JsonProperty
    private List<UserRole> userRoles = new ArrayList<>();
	
	@JsonProperty
    private List<DataSet> dataSets = new ArrayList<>();
	
	@JsonProperty
    private List<UserGroup> userGroups = new ArrayList<>();
	
}

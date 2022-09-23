package com.ezest.dhis2.portal.service;

import java.util.List;

import org.hisp.dhis.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezest.dhis2.portal.config.PortalConfig;
import com.ezest.dhis2.portal.model.UserGroup;

@Service
public class UserGroupService {
	
    @Autowired
	private PortalConfig portalConfig;
	
	public List<UserGroup> getUserGroups() {
		List<UserGroup> userGroups = portalConfig.getPortalDhis2().getUserGroups(Query.instance());
		//TODO Add required CUSTOM logic here
		return userGroups;
	}

	public UserGroup getUserGroup(String uid) {
		UserGroup userGroup = portalConfig.getPortalDhis2().getObject("userGroups", uid, UserGroup.class);
		return userGroup;
	}

}

package com.ezest.dhis2.portal.service;

import java.util.List;

import org.hisp.dhis.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezest.dhis2.portal.config.PortalConfig;
import com.ezest.dhis2.portal.model.UserRole;

@Service
public class UserRoleService {

	@Autowired
	private PortalConfig portalConfig;

	public List<UserRole> getAllUserRoles() {
		return portalConfig.getPortalDhis2().getUserRoles(Query.instance());
	}

	public UserRole getUserRole(String uid) {
		UserRole userRoleResponse = portalConfig.getPortalDhis2().getObject("userRoles", uid, UserRole.class);
		return userRoleResponse;
	}
}

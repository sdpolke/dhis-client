package com.ezest.dhis2.portal.service;

import java.util.List;

import org.hisp.dhis.model.OrgUnitGroup;
import org.hisp.dhis.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezest.dhis2.portal.config.PortalConfig;

@Service
public class OrgUnitGroupService {

	@Autowired
	private PortalConfig portalConfig;
	
	
	public List<OrgUnitGroup> getAllOrgUnitGroups() {
		return portalConfig.getDhis2().getOrgUnitGroups(Query.instance());
	}


	public OrgUnitGroup getOrgUnitGroup(String uid) {
		return portalConfig.getDhis2().getOrgUnitGroup(uid);
	}
}


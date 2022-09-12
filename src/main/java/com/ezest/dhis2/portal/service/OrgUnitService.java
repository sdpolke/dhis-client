package com.ezest.dhis2.portal.service;

import java.util.List;

import org.hisp.dhis.model.OrgUnit;
import org.hisp.dhis.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezest.dhis2.portal.config.PortalConfig;

@Service
public class OrgUnitService {

	@Autowired
	private PortalConfig portalConfig;
	
	
	public List<OrgUnit> getAllOrgUnits() {
		return portalConfig.getDhis2().getOrgUnits(Query.instance());
	}


	public OrgUnit getOrgUnit(String uid) {
		return portalConfig.getDhis2().getOrgUnit(uid);
	}

}

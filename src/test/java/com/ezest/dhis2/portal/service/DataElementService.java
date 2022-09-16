package com.ezest.dhis2.portal.service;

import java.util.List;

import org.hisp.dhis.model.DataElement;
import org.hisp.dhis.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezest.dhis2.portal.config.PortalConfig;

@Service
public class DataElementService {

	@Autowired
	private PortalConfig portalConfig;
	
	public List<DataElement> getAllDataElements() {
		return portalConfig.getDhis2().getDataElements(Query.instance());
	}

	public DataElement getDataElement(String uid) {
		return portalConfig.getDhis2().getDataElement(uid);
	}

}

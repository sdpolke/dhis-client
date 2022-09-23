package com.ezest.dhis2.portal.service;

import java.util.List;

import com.ezest.dhis2.portal.repository.DataElementRepository;
import org.hisp.dhis.model.DataElement;
import org.hisp.dhis.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezest.dhis2.portal.config.PortalConfig;

@Service
public class DataElementService {

	@Autowired
	private PortalConfig portalConfig;

	@Autowired
	private DataElementRepository dataElementRepository;
	
	public List<DataElement> getAllDataElements() {
		List<com.ezest.dhis2.portal.entity.DataElement> des = dataElementRepository.findAll();
		des.forEach(System.err::println);
		return portalConfig.getDhis2().getDataElements(Query.instance());
	}

	public DataElement getDataElement(String uid) {
		return portalConfig.getDhis2().getDataElement(uid);
	}

}

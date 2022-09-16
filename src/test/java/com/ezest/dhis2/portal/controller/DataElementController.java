package com.ezest.dhis2.portal.controller;

import java.util.List;

import org.hisp.dhis.model.DataElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezest.dhis2.portal.service.DataElementService;

@RequestMapping(value = "dataElements")
@RestController
public class DataElementController {

	@Autowired
	private DataElementService dataElementService;
	
	@GetMapping
	public List<DataElement> getAllDataElements() {
		return dataElementService.getAllDataElements();
	}

	@GetMapping("/{uid}")
	public DataElement getDataElement(String uid) {
		return dataElementService.getDataElement(uid);
	}

}

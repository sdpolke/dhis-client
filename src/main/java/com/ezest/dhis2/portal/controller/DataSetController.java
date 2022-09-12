package com.ezest.dhis2.portal.controller;

import java.util.List;

import org.hisp.dhis.response.object.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezest.dhis2.portal.model.DataSet;
import com.ezest.dhis2.portal.model.DataSetRequest;
import com.ezest.dhis2.portal.service.DataSetService;

@RequestMapping(value = "dataSets")
@RestController
public class DataSetController {

	@Autowired
	private DataSetService dataSetService;

	@GetMapping
	public List<DataSet> getAllDataSets() {
		return dataSetService.getAllDataSets();
	}
	
	@GetMapping("/{uid}")
	public DataSet getDataSet(@PathVariable String uid) {
		return dataSetService.getDataSet(uid);
	}

	@PostMapping
	public String createDataSet(@RequestBody DataSetRequest dataSetRequest) {
		return dataSetService.createDataSet(dataSetRequest);
	}

	@PostMapping("/save")
	public DataSet saveDataSet(@RequestBody DataSet dataSet) {
		ObjectResponse res = dataSetService.saveDataSet(dataSet);
		System.err.println(res.getResponse().toString());
		return dataSet;
	}
}

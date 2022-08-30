package com.ezest.dhis2.portal.controller;

import com.ezest.dhis2.portal.config.PortalConfig;
import com.ezest.dhis2.portal.model.DataSet;
import com.ezest.dhis2.portal.model.DataSetRequest;
import com.ezest.dhis2.portal.service.DataSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "dataset")
@RestController
public class DataSetController {
    @Autowired
    DataSetService dataSetService;
    @Autowired
    PortalConfig config;

    @PostMapping("/create")
    public String createDataSet(@RequestBody DataSetRequest dataSetRequest) {
        return dataSetService.createDataSet(dataSetRequest);
    }
}

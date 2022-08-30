package com.ezest.dhis2.portal.service;

import com.ezest.dhis2.portal.adapter.DataSetAdapter;
import com.ezest.dhis2.portal.model.DataSetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataSetService {
    @Autowired
    DataSetAdapter dataSetAdapter;
    public String createDataSet(DataSetRequest dataset) {
       return dataSetAdapter.createDataSet(dataset);
    }
}

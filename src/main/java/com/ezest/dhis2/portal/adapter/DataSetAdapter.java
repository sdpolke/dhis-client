package com.ezest.dhis2.portal.adapter;

import java.util.Objects;

import org.hisp.dhis.response.Status;
import org.hisp.dhis.response.object.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.ezest.dhis2.portal.config.PortalConfig;
import com.ezest.dhis2.portal.model.DataSetRequest;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DataSetAdapter {
    @Autowired
    PortalConfig config;
    public String createDataSet(DataSetRequest dataset) {

        HttpEntity<DataSetRequest> request = new HttpEntity<>(dataset);
        ResponseEntity<ObjectResponse> dataSetResponse = config.restTemplate().exchange(config.metadataEndpoint(),
                HttpMethod.POST, request, ObjectResponse.class);

        if(!isSucceed(dataSetResponse.getBody())) {
            log.error("Create DataSet call failed.");
            throw new RuntimeException("Create DataSet call failed.");
        }

        System.out.println(Objects.toString(dataSetResponse.getBody()));

        return "Successful";

    }
    private boolean isSucceed(ObjectResponse objectResponse) {
        return Status.OK == objectResponse.getStatus();

    }
}

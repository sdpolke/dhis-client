package com.ezest.dhis2.portal.service;

import java.util.List;

import org.hisp.dhis.query.Query;
import org.hisp.dhis.response.object.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezest.dhis2.portal.adapter.DataSetAdapter;
import com.ezest.dhis2.portal.config.PortalConfig;
import com.ezest.dhis2.portal.model.DataSet;
import com.ezest.dhis2.portal.model.DataSetRequest;

@Service
public class DataSetService {

	@Autowired
	DataSetAdapter dataSetAdapter;
	
	@Autowired
	private PortalConfig portalConfig;
	
	
	public ObjectResponse saveDataSet(DataSet dataset) {
		return portalConfig.getPortalDhis2().saveMetadataObject("dataSets", dataset);
	}

	public List<DataSet> getAllDataSets() {
		return portalConfig.getPortalDhis2().getDataSets(Query.instance());
	}

	public String createDataSet(DataSetRequest dataset) {
		return dataSetAdapter.createDataSet(dataset);
	}

	public DataSet getDataSet(String uid) {
		DataSet dataSetRes = portalConfig.getPortalDhis2().getObject("dataSets", uid, DataSet.class);
		return dataSetRes;
	}
}

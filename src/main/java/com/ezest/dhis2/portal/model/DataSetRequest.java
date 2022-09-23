package com.ezest.dhis2.portal.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DataSetRequest {
	
	@JsonProperty
    private List<DataSet> dataSets;
}

package com.ezest.dhis2.portal.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
@Getter
@Setter
public class DataSetRequest {
	
	@JsonProperty
    private List<DataSet> dataSets;
}

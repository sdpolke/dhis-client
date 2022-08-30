package com.ezest.dhis2.portal.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataSetElements {
    private DataSet dataSet;
    private String id;
    private DataElement dataElement;
}

package com.ezest.dhis2.portal.model;

import lombok.Getter;
import lombok.Setter;
import org.hisp.dhis.model.OrgUnit;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DataSet {
    private boolean validCompleteOnly;
    private boolean skipOffline;
    private int timelyDays;
    private String name;
    private String shortName;
    private long code;
    private String periodType;
    private int openFuturePeriods;
    private int expiryDays;
    private CategoryCombo categoryCombo;
    private List<DataSetElements> dataSetElements;
    private String id;
    private List<Indicators> indicators = new ArrayList<>();
    private List<LegendSets> legendSets = new ArrayList<>();
    private List<OrgUnit> organisationUnits = new ArrayList<>();
}

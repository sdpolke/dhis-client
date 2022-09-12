package com.ezest.dhis2.portal.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hisp.dhis.model.NameableObject;
import org.hisp.dhis.model.OrgUnit;
import org.hisp.dhis.model.PeriodType;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DataSet extends NameableObject {

	@JsonProperty
	private boolean validCompleteOnly;
	@JsonProperty
	private boolean skipOffline;
	@JsonProperty
	private int timelyDays;
	@JsonProperty
	private String name;
	@JsonProperty
	private String displayName;
	//@JsonProperty
	//private PeriodType periodType;
	@JsonProperty
	private int openFuturePeriods;
	@JsonProperty
	private int expiryDays;
	@JsonProperty
	private CategoryCombo categoryCombo;
	@JsonProperty
	private List<DataSetElements> dataSetElements;
	@JsonProperty
	private List<Indicators> indicators = new ArrayList<>();
	@JsonProperty
	private List<LegendSets> legendSets = new ArrayList<>();
	@JsonProperty
	private List<OrgUnit> organisationUnits = new ArrayList<>();

}

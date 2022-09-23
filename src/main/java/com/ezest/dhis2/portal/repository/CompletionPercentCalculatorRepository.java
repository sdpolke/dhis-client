package com.ezest.dhis2.portal.repository;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class CompletionPercentCalculatorRepository {
	
	private static final String PERCENT_QUERY = 
			"select data*100.00 /(select count(dataelementid) as num from  public.datasetelement where datasetid = :dataSetId) as percentage"
			+ " from (select count (distinct dataelementid) as data from (SELECT * FROM public.datavalue where sourceid = :ouId"
			+ " and periodid = (select periodid from public.period where TO_CHAR(startdate, 'YYYY-MM-DD') like :givenDate"
			+ " and periodtypeid = (select periodtypeid from public.dataset where datasetid=:dataSetId))"
			+ " and dataelementid in (select dataelementid from public.datasetelement where datasetid =:dataSetId"
			+ " )) table1) table2";
	
	
	@PersistenceContext
	private EntityManager entityManager;

	public double calculatePercentageOfCompletion(Long dataSetId, Long ouId, String date) {
		Query query = entityManager.createNativeQuery(PERCENT_QUERY);
		query.setParameter("dataSetId", dataSetId);
		query.setParameter("ouId", ouId);
		query.setParameter("givenDate", date);

		BigDecimal result = (BigDecimal) query.getSingleResult();
		return result.doubleValue();
	}
	
	public Long findPeriodId(Long periodTypeId, String givenDate) {
		Query query = entityManager
				.createNativeQuery("select periodid from public.period where TO_CHAR(startdate, 'YYYY-MM-DD') like :givenDate and periodtypeid = :periodTypeId");
		
		
		query.setParameter("givenDate", givenDate);
		query.setParameter("periodTypeId", periodTypeId);

		BigInteger result = (BigInteger) query.getSingleResult();
		return result.longValue();
	}
	
	public Long findDataElementCount(Long dataSetId) {
		Query query = entityManager
				.createNativeQuery("select count(de.dataelementid) from public.datasetelement de where de.datasetid=:dataSetId");
		query.setParameter("dataSetId", dataSetId);

		BigInteger result = (BigInteger) query.getSingleResult();
		return result.longValue();
	}
	
	public Long findPeriodTypeByDatasetId(Long dataSetId) {
		Query query = entityManager
				.createNativeQuery("select ds.periodtypeid from public.dataset ds where datasetid=:dataSetId");
		query.setParameter("dataSetId", dataSetId);

		int result = (int) query.getSingleResult();
		return Long.valueOf(result);
	}
}

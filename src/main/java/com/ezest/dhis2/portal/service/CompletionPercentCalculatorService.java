package com.ezest.dhis2.portal.service;

import com.ezest.dhis2.portal.model.CompletionPercentageCalculatorReq;
import com.ezest.dhis2.portal.repository.CompletionPercentCalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class CompletionPercentCalculatorService {
    @Autowired
    CompletionPercentCalculatorRepository completionPercentCalculatorRepository;

    public String calculatePercentageOfCompletion(CompletionPercentageCalculatorReq request) {
//    	Long periodTypeId = completionPercentCalculatorRepository.findPeriodTypeByDatasetId(request.getDataSetId());
//    	System.err.println(periodTypeId);
//    	
//    	Long deCount = completionPercentCalculatorRepository.findDataElementCount(request.getDataSetId());
//    	System.err.println(deCount);
//    	
//    	Long periodId = completionPercentCalculatorRepository.findPeriodId(periodTypeId, request.getDate());
//    	System.err.println(periodId);
        DecimalFormat decfor = new DecimalFormat("0.00");
        return decfor.format(completionPercentCalculatorRepository.calculatePercentageOfCompletion(request.getDataSetId(), request.getOUId(), request.getDate()));
    }
}

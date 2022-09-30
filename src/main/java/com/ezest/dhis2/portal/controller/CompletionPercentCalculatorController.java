package com.ezest.dhis2.portal.controller;

import com.ezest.dhis2.portal.model.CompletionPercentageCalculatorReq;
import com.ezest.dhis2.portal.service.CompletionPercentCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "percentOfCompletion")
public class CompletionPercentCalculatorController {

    @Autowired
    CompletionPercentCalculatorService completionPercentCalculatorService;
    
    @GetMapping
    public String calculatePercentageOfCompletion(@RequestBody CompletionPercentageCalculatorReq request) {
        return completionPercentCalculatorService.calculatePercentageOfCompletion(request);
    }
}

package com.cognitive.health.toolshed.services.impl;

import com.cognitive.health.toolshed.domain.surveys.Depression;
import com.cognitive.health.toolshed.ras.IDepressionRepository;
import com.cognitive.health.toolshed.services.IDepressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class DepressionService implements IDepressionService {

    @Autowired
    IDepressionRepository depressionRepository;

    @Override
    public Depression saveDepressionSurvey (Depression survey){
        survey.setDateRecorded(new Timestamp(new Date().getTime()));
        int total = survey.getPhq1() + survey.getPhq2() + survey.getPhq3() + survey.getPhq4() + survey.getPhq5() +
                survey.getPhq6() + survey.getPhq7() + survey.getPhq8() + survey.getPhq9() + survey.getPhq10();
        survey.setTotal(total);
        return depressionRepository.save(survey);
    }
}

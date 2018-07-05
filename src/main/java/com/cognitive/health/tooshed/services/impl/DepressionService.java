package com.cognitive.health.tooshed.services.impl;

import com.cognitive.health.tooshed.domain.surveys.Depression;
import com.cognitive.health.tooshed.ras.IDepressionRepository;
import com.cognitive.health.tooshed.services.IDepressionService;
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
        return depressionRepository.save(survey);
    }
}

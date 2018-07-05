package com.cognitive.health.tooshed.services.impl;

import com.cognitive.health.tooshed.domain.surveys.Personality;
import com.cognitive.health.tooshed.ras.IPersonalityRepository;
import com.cognitive.health.tooshed.services.IPersonalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class PersonalityService implements IPersonalityService {

    @Autowired
    IPersonalityRepository personalityRepository;

    @Override
    public Personality savePersonalitySurvey (Personality survey){
        survey.setDateRecorded(new Timestamp(new Date().getTime()));
        return personalityRepository.save(survey);
    }
}
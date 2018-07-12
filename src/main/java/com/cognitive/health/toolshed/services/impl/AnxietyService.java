package com.cognitive.health.toolshed.services.impl;

import com.cognitive.health.toolshed.domain.surveys.Anxiety;
import com.cognitive.health.toolshed.ras.IAnxietyRepository;
import com.cognitive.health.toolshed.services.IAnxietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class AnxietyService implements IAnxietyService {
    @Autowired
    IAnxietyRepository anxietyRepository;

    @Override
    public Anxiety saveAnxietySurvey (Anxiety survey){
        survey.setDateRecorded(new Timestamp(new Date().getTime()));
        return anxietyRepository.save(survey);
    }
}

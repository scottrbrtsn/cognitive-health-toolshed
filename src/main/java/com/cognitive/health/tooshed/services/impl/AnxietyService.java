package com.cognitive.health.tooshed.services.impl;

import com.cognitive.health.tooshed.domain.surveys.Anxiety;
import com.cognitive.health.tooshed.ras.IAnxietyRepository;
import com.cognitive.health.tooshed.services.IAnxietyService;
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

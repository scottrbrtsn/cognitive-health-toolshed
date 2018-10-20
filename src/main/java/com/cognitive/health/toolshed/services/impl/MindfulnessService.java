package com.cognitive.health.toolshed.services.impl;

import com.cognitive.health.toolshed.domain.surveys.Mindfulness;
import com.cognitive.health.toolshed.ras.IMindfulnessRepository;
import com.cognitive.health.toolshed.services.IMindfulnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class MindfulnessService implements IMindfulnessService {

    @Autowired
    IMindfulnessRepository mindfulnessRepository;

    @Override
    public Mindfulness saveMindfulnessSurvey (Mindfulness survey){
        survey.setDateRecorded(new Timestamp(new Date().getTime()));
        return mindfulnessRepository.save(survey);
    }
}

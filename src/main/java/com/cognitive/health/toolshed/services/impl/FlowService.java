package com.cognitive.health.toolshed.services.impl;

import com.cognitive.health.toolshed.domain.surveys.Flow;
import com.cognitive.health.toolshed.ras.IFlowRepository;
import com.cognitive.health.toolshed.services.IFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class FlowService implements IFlowService {

    @Autowired
    IFlowRepository flowRepository;

    @Override
    public Flow saveFlowSurvey (Flow survey){
        survey.setDateRecorded(new Timestamp(new Date().getTime()));
        return flowRepository.save(survey);
    }
}

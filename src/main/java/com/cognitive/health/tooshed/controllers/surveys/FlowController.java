package com.cognitive.health.tooshed.controllers.surveys;

import com.cognitive.health.tooshed.domain.surveys.Flow;
import com.cognitive.health.tooshed.ras.IFlowRepository;
import com.cognitive.health.tooshed.services.IFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Handles the REST endpoints for survey data delivery
 * @author scottrobertson
 *
 */
@RestController
@RequestMapping(value = "/surveys/flow")
@CrossOrigin(origins ="http://localhost:4200")
public class FlowController {

    @Autowired
    private IFlowRepository flowRepository;

    @Autowired
    private IFlowService flowService;

    @RequestMapping(value = "/getSurveys", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<Flow>> getFlowSurveys() {
        return new ResponseEntity<>(flowRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/saveSurvey", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Flow> saveSurvey(@RequestBody Flow survey) {
        return new ResponseEntity<>(flowService.saveFlowSurvey(survey), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteSurveys", method = RequestMethod.GET)
    public @ResponseBody
    void deleteAllSurveys() {
        flowRepository.deleteAll();
    }

}
package com.cognitive.health.toolshed.controllers.surveys;

import com.cognitive.health.toolshed.domain.surveys.Mindfulness;
import com.cognitive.health.toolshed.ras.IMindfulnessRepository;
import com.cognitive.health.toolshed.services.IMindfulnessService;
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
@RequestMapping(value = "/surveys/mindfulness")
@CrossOrigin(origins ="https://cognitive-health-ui.herokuapp.com,https://scottrbrtsn.github.io")
public class MindfulnessController {

    @Autowired
    private IMindfulnessRepository mindfulnessRepository;

    @Autowired
    private IMindfulnessService mindfulnessService;

    @RequestMapping(value = "/getSurveys", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<Mindfulness>> getAnxietySurveys() {
        return new ResponseEntity<>(mindfulnessRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/saveSurvey", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Mindfulness> saveSurvey(@RequestBody Mindfulness survey) {
        return new ResponseEntity<>(mindfulnessService.saveMindfulnessSurvey(survey), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteSurveys", method = RequestMethod.GET)
    public @ResponseBody
    void deleteAllSurveys() {
        mindfulnessRepository.deleteAll();
    }

}
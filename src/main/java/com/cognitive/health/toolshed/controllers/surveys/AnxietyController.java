package com.cognitive.health.toolshed.controllers.surveys;

import com.cognitive.health.toolshed.domain.surveys.Anxiety;
import com.cognitive.health.toolshed.ras.IAnxietyRepository;
import com.cognitive.health.toolshed.services.IAnxietyService;
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
@RequestMapping(value = "/surveys/anxiety")
@CrossOrigin(origins ="https://cognitive-health-ui.herokuapp.com,https://scottrbrtsn.github.io")
public class AnxietyController {

    @Autowired
    private IAnxietyRepository anxietyRepository;

    @Autowired
    private IAnxietyService anxietyService;

    @RequestMapping(value = "/getSurveys", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<Anxiety>> getAnxietySurveys() {
        return new ResponseEntity<>(anxietyRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/saveSurvey", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Anxiety> saveSurvey(@RequestBody Anxiety survey) {
        return new ResponseEntity<>(anxietyService.saveAnxietySurvey(survey), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteSurveys", method = RequestMethod.GET)
    public @ResponseBody
    void deleteAllSurveys() {
        anxietyRepository.deleteAll();
    }

}

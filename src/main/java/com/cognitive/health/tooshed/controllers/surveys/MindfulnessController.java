package com.cognitive.health.tooshed.controllers.surveys;

import com.cognitive.health.tooshed.domain.surveys.Mindfulness;
import com.cognitive.health.tooshed.ras.IMindfulnessRepository;
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
@CrossOrigin(origins ="http://localhost:4200")
public class MindfulnessController {

    @Autowired
    private IMindfulnessRepository mindfulnessRepository;

    @RequestMapping(value = "/getSurveys", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<Mindfulness>> getAnxietySurveys() {
        return new ResponseEntity<>(mindfulnessRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/saveSurvey", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Mindfulness> saveSurvey(@RequestBody Mindfulness survey) {
        return new ResponseEntity<>(mindfulnessRepository.save(survey), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteSurveys", method = RequestMethod.GET)
    public @ResponseBody
    void deleteAllSurveys() {
        mindfulnessRepository.deleteAll();
    }

}
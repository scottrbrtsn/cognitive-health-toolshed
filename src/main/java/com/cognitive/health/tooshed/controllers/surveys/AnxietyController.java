package com.cognitive.health.tooshed.controllers.surveys;

import com.cognitive.health.tooshed.domain.surveys.Anxiety;
import com.cognitive.health.tooshed.ras.IAnxietyRepository;
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
@CrossOrigin(origins ="http://localhost:4200")
public class AnxietyController {

    @Autowired
    private IAnxietyRepository anxietyRepository;

    @RequestMapping(value = "/getSurveys", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<Anxiety>> getAnxietySurveys() {
        return new ResponseEntity<>(anxietyRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/saveSurvey", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Anxiety> saveSurvey(@RequestBody Anxiety survey) {
        return new ResponseEntity<>(anxietyRepository.save(survey), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteSurveys", method = RequestMethod.GET)
    public @ResponseBody
    void deleteAllSurveys() {
        anxietyRepository.deleteAll();
    }

}

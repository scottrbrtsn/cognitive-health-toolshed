package com.cognitive.health.toolshed.controllers.surveys;

import com.cognitive.health.toolshed.domain.surveys.Personality;
import com.cognitive.health.toolshed.ras.IPersonalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/surveys/personality")
@CrossOrigin(origins ="http://localhost:4200")
public class PersonalityController {

    @Autowired
    private IPersonalityRepository personalityRepository;

    @RequestMapping(value = "/getSurveys", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<Personality>> getAnxietySurveys() {
        return new ResponseEntity<>(personalityRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/saveSurvey", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Personality> saveSurvey(@RequestBody Personality survey) {
        return new ResponseEntity<>(personalityRepository.save(survey), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteSurveys", method = RequestMethod.GET)
    public @ResponseBody
    void deleteAllSurveys() {
        personalityRepository.deleteAll();
    }

}
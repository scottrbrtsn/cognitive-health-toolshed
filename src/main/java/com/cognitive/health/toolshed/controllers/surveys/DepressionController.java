package com.cognitive.health.toolshed.controllers.surveys;

import com.cognitive.health.toolshed.domain.surveys.Depression;
import com.cognitive.health.toolshed.ras.IDepressionRepository;
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
@RequestMapping(value = "/surveys/depression")
@CrossOrigin(origins ="http://localhost:4200")
public class DepressionController {

    @Autowired
    private IDepressionRepository depressionRepository;

    @RequestMapping(value = "/getSurveys", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<Depression>> getAnxietySurveys() {
        return new ResponseEntity<>(depressionRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/saveSurvey", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Depression> saveSurvey(@RequestBody Depression survey) {
        return new ResponseEntity<>(depressionRepository.save(survey), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteSurveys", method = RequestMethod.GET)
    public @ResponseBody
    void deleteAllSurveys() {
        depressionRepository.deleteAll();
    }

}
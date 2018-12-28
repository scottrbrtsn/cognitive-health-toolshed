package com.cognitive.health.toolshed.controllers.surveys;

import com.cognitive.health.toolshed.domain.surveys.Depression;
import com.cognitive.health.toolshed.ras.IDepressionRepository;
import com.cognitive.health.toolshed.services.IDepressionService;
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
@CrossOrigin(origins ="https://cognitive-health-ui.herokuapp.com,https://scottrbrtsn.github.io")
public class DepressionController {

    @Autowired
    private IDepressionRepository depressionRepository;

    @Autowired
    private IDepressionService depressionService;

    @RequestMapping(value = "/getSurveys", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<Depression>> getAnxietySurveys() {
        return new ResponseEntity<>(depressionRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/saveSurvey", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Depression> saveSurvey(@RequestBody Depression survey) {
        return new ResponseEntity<>(depressionService.saveDepressionSurvey(survey), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteSurveys", method = RequestMethod.GET)
    public @ResponseBody
    void deleteAllSurveys() {
        depressionRepository.deleteAll();
    }

}
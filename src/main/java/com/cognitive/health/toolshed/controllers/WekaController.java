package com.cognitive.health.toolshed.controllers;

import com.cognitive.health.toolshed.services.impl.WekaTimeSeriesService;
import com.cognitive.health.toolshed.services.impl.WekaClassifierService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/weka")
public class WekaController {

    private static final Logger LOGGER = Logger.getLogger(WekaController.class.getName());

    @Autowired
    WekaClassifierService wekaClassifierServiceService;

    @Autowired
    WekaTimeSeriesService wekaTimeSeriesService;

    @RequestMapping(value = "/runClassifier", method = RequestMethod.GET)
    public ResponseEntity<double[]> runClassifier() throws Exception{
        LOGGER.debug("runClassifier");
        return new ResponseEntity<>(wekaClassifierServiceService.runClassifierExample(), new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/runTimeSeries",method = RequestMethod.GET)
    public ResponseEntity<List<List<Double>>> runTimeSeries() throws Exception{
        LOGGER.debug("runTimeSeries");
        return new ResponseEntity<>(wekaTimeSeriesService.runTimeSeriesExample(), new HttpHeaders(), HttpStatus.OK);
    }

}
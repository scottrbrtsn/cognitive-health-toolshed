package com.cognitive.health.toolshed.controllers;

import com.cognitive.health.toolshed.services.IChatService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.io.IOException;

@RestController
@RequestMapping(value = "/chat")
@CrossOrigin(origins ="http://localhost:4200")
public class ChatController {

    private static final Logger LOGGER = Logger.getLogger(ChatController.class.getName());

    @Autowired
    IChatService chatService;

    //e.g. http://localhost:9000/chat/getMarkov?userInput=Hello+I+love+to+talk+grass.
    @RequestMapping(value = "/getMarkov", method = RequestMethod.GET)
    public ResponseEntity<String> startMarkov(@PathParam ("userInput") String userInput) {
        LOGGER.debug("startMarkov");
        return new ResponseEntity<>(chatService.getPhrase(userInput), new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/setup", method = RequestMethod.GET)
    public ResponseEntity<String> setup(@PathParam ("author") String author) throws IOException {
        LOGGER.debug("setupMarkov");
        return new ResponseEntity<>(chatService.setup(author), new HttpHeaders(), HttpStatus.OK);
    }
}

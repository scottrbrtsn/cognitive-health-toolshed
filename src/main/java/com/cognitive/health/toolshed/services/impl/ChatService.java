package com.cognitive.health.toolshed.services.impl;

import com.cognitive.health.toolshed.services.IChatService;
import com.cognitive.health.toolshed.services.chat.MarkovCollection;
import com.cognitive.health.toolshed.services.chat.PhraseProcessor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ChatService implements IChatService {

    private static final Logger LOGGER = Logger.getLogger(ChatService.class.getName());

    @Autowired
    private MarkovCollection markovCollection;

    @Autowired
    private PhraseProcessor phraseProcessor;

    @Override
    public String getPhrase(String userInput) {
        return phraseProcessor.splitAndRespond(userInput);

    }

    @Override
    public String setup(String author) throws IOException {
        return markovCollection.setup(author);

    }


}

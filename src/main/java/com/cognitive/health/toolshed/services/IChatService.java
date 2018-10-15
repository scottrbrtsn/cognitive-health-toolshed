package com.cognitive.health.toolshed.services;

import java.io.IOException;

public interface IChatService {

    String getPhrase(String mode);

    String setup(String author) throws IOException;
}

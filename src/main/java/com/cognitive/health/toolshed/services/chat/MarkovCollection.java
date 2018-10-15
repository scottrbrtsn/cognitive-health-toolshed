package com.cognitive.health.toolshed.services.chat;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by scottrobertson on 10/24/17.
 */
@Component
public class MarkovCollection {

    private static final Logger LOGGER = Logger.getLogger(MarkovCollection.class.getName());


    private Hashtable<String, Vector<String>> markovChain = new Hashtable<String, Vector<String>>();
    private List<String> commonWords = new ArrayList<>();


    public void addSingleWordToMarkovCollection(String word){
        Vector<String> oneWords = markovChain.get("_one");
        oneWords.add(word);
    }

    public void addWordsToMarkovCollection(String[] words){
        // Loop through each word, check if it's already added
        // if its added, then get the suffix vector and add the word
        // if it hasn't been added then add the word to the list
        // if its the first or last word then select the _start / _end key
        // then generate the next sentence
        // Add the start and end words to their own
        for (int i=0; i<words.length; i++) {
            if (i == 0) {//first word of input
                Vector<String> startWords = markovChain.get("_start");//for some reason start words have a lot more than I'd expect
                startWords.add(words[i]);
                Vector<String> suffix = markovChain.get(words[i].toLowerCase());
                updateMarkovChain(words, i, suffix);
            } else if (i == words.length - 1) { //last word of input
                Vector<String> endWords = markovChain.get("_end");
                if (!words[i].contains(".") ||
                        !words[i].contains("?") ||
                        !words[i].contains("!")){
                    words[i] = words[i] + ".";
                }
                endWords.add(words[i].replace(".", ""));
                //middle words/sentences of input
            } else {
                Vector<String> suffix = markovChain.get(words[i]);
                //  System.out.println("suffix: " + suffix);
                updateMarkovChain(words, i, suffix);
                if (words[i].contains(".") ||//input had more than one sentence
                        words[i].contains("?") ||
                        words[i].contains("!")){
                    Vector<String> endWords = markovChain.get("_end");
                    endWords.add(words[i].replace(".", ""));
                }
            }
        }

    }

    public void updateMarkovChain(String[] words, int i, Vector<String> suffix) {
        if (suffix == null) {
            if(!words[i+1].isEmpty()) {
                suffix = new Vector<>();
                suffix.add(words[i + 1].replace(".", ""));
                markovChain.put(words[i].toLowerCase(), suffix);
            }
        } else {
            if(!words[i+1].isEmpty()) {
                suffix.add(words[i + 1].replace(".", ""));
            }
        }
    }

    public Vector<String> getWordFromMarkovChain(String key){
        return markovChain.get(key);
    }

    public Set getKeySet(){
        return markovChain.keySet();
    }

    public List<String> getCommonWords(){
        return commonWords;
    }

    public String setup (String author) throws IOException {
        if(markovChain.size() == 0) {
            // Create the first three entries (k:_start, k:_end, k:_one)
            //generic chain
            markovChain.put("_start", new Vector<>());//words that start sentences
            markovChain.put("_end", new Vector<>());//words that end sentences
            markovChain.put("_one", new Vector<>());//one word sentences
            markovChain.put("_questions", new Vector<>());//one word sentences

            commonWords.add("the");
            commonWords.add("a");
            commonWords.add("I");
            commonWords.add("he");
            commonWords.add("she");
            commonWords.add("it");
            commonWords.add("at");
            commonWords.add("on");
            commonWords.add("in");
            commonWords.add("of");
            commonWords.add("what");
            commonWords.add("do");
            commonWords.add("you");
            commonWords.add("how");
            commonWords.add("are");
            commonWords.add("is");

            if (StringUtils.isEmpty(author)) {
                addWordsToMarkovCollection(readFile("Whitman").split(" "));
                addWordsToMarkovCollection(readFile("Oscar_Wilde").split(" "));
                addWordsToMarkovCollection(readFile("Shakespeare").split(" "));
                addWordsToMarkovCollection(readFile("Asimov").split(" "));
                addWordsToMarkovCollection(readFile("Rumi").split(" "));
            } else {
                addWordsToMarkovCollection(readFile(author).split(" "));
            }

            return "Success";
        }else{
            return "Markov Chain already set up; size: " + markovChain.size();
        }
    }

    private String readFile (String fileName) throws IOException {
        File file = ResourceUtils.getFile("classpath:literature/" +fileName + ".txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line + " ");
                line = br.readLine();
            }
            return sb.toString();
        }finally {
            br.close();
        }
    }

}

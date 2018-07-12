package com.cognitive.health.toolshed.domain;

import lombok.Data;

import java.util.Random;

//@Entity
@Data
public class Individual {

    int fitness = 0;
    int[] traits = new int[5];

    public Individual() {
        Random rn = new Random();

        //Set traits randomly for each individual
        for (int i = 0; i < traits.length; i++) {
            traits[i] = Math.abs(rn.nextInt() % 2);
        }

        fitness = 0;
    }

    //Calculate fitness
    public void calcFitness() {

        fitness = 0;
        for (int i = 0; i < 5; i++) {
            if (traits[i] == 1) {
                ++fitness;
            }
        }
    }

}

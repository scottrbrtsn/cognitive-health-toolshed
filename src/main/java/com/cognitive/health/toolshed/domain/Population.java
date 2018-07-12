package com.cognitive.health.toolshed.domain;

import lombok.Data;

//@Entity
@Data
public class Population {

    //TODO customize size of population, or add population growth
    int popSize = 10;
    Individual[] individuals = new Individual[10];
    int fittest = 0;

    public void initializePopulation() {
        for (int i = 0; i < individuals.length; i++) {
            individuals[i] = new Individual();
        }
    }

    //TODO get Fittest Male
    public Individual getFittest() {
        int maxFit = Integer.MIN_VALUE;
        int maxFitIndex = 0;
        for (int i = 0; i < individuals.length; i++) {
            if (maxFit <= individuals[i].getFitness()) {
                maxFit = individuals[i].getFitness();
                maxFitIndex = i;
            }
        }
        fittest = individuals[maxFitIndex].getFitness();
        return individuals[maxFitIndex];
    }

    //TODO get Fittest Female
    public Individual getSecondFittest() {
        int maxFit1 = 0;
        int maxFit2 = 0;
        for (int i = 0; i < individuals.length; i++) {
            if (individuals[i].getFitness() > individuals[maxFit1].getFitness()) {
                maxFit2 = maxFit1;
                maxFit1 = i;
            } else if (individuals[i].getFitness() > individuals[maxFit2].getFitness()) {
                maxFit2 = i;
            }
        }
        return individuals[maxFit2];
    }

    //Get index of least fittest individual
    public int getLeastFittestIndex() {
        int minFitVal = Integer.MAX_VALUE;
        int minFitIndex = 0;
        for (int i = 0; i < individuals.length; i++) {
            if (minFitVal >= individuals[i].getFitness()) {
                minFitVal = individuals[i].getFitness();
                minFitIndex = i;
            }
        }
        return minFitIndex;
    }

    //Calculate fitness of each individual
    //TODO calculate fitness based on trait values
    public void calculateFitness() {

        for (int i = 0; i < individuals.length; i++) {
            individuals[i].calcFitness();
        }
        getFittest();
    }

    public void calculateIndividualConsequences(){
        //a single highly "fit" individual, might be killed for some reason
        //
    }

    //Average all traits from all individuals so that the population can be measured
    public void calculatePopulationFitness(){

    }

    public void calculatePopulationConsequences(){
        //unbalanced society will lead to destruction
        //
    }

}

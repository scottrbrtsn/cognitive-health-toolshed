package com.cognitive.health.toolshed.services.impl;

import com.cognitive.health.toolshed.domain.Individual;
import com.cognitive.health.toolshed.domain.Population;
import com.cognitive.health.toolshed.services.IGeneticAlgorithm;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GeneticAlgorithm implements IGeneticAlgorithm {
    private static final Logger LOGGER = Logger.getLogger(GeneticAlgorithm.class.getName());

    Population population = new Population();
    Individual fittest;
    Individual secondFittest;
    int generationCount = 0;

    @Override
    public String runGeneticAlgorithm() {

        Random rn = new Random();

        //Initialize population
        population.initializePopulation();

        //Calculate fitness of each individual
        population.calculateFitness();

       LOGGER.info("Generation: " + generationCount + " Fittest: " + population.getFittest());

        //While population does not get an individual with maximum fitness
        while (population.getFittest().getFitness() < 5) {
            ++generationCount;

            //Do selection
            selection();

            //Do crossover
            crossover();

            //Do mutation under a random probability
            if (rn.nextInt() % 7 < 5) {
                mutation();
            }

            //Add fittest offspring to population
            addFittestOffspring();

            //Calculate new fitness value
            population.calculateFitness();

            LOGGER.info("Generation: " + generationCount + " Fittest: " + population.getFittest().getFitness());
        }

        LOGGER.info("Solution found in generation " + generationCount);
        LOGGER.info("Fitness: " + population.getFittest().getFitness());
        LOGGER.info("Traits: ");
        LOGGER.info(population.getFittest().getTraits());
        LOGGER.info("");

        return "Generation: " + generationCount + " Fittest: " + population.getFittest().getFitness();

    }

    //Selection
    //Assumes asexuality
    //TODO: make gender differences, so, get fittestMale, getFittestFemale
    private void selection() {
        //Select the fittest individual
        fittest = population.getFittest();

        //Select the second fittest individual
        secondFittest = population.getSecondFittest();
    }

    //Crossover
    private void crossover() {
        Random rn = new Random();

        //Select a random crossover point
        int crossOverPoint = rn.nextInt(population.getIndividuals()[0].getTraits().length);

        //Swap values among parents
        for (int i = 0; i < crossOverPoint; i++) {
            int temp = fittest.getTraits()[i];
            fittest.getTraits()[i] = secondFittest.getTraits()[i];
            secondFittest.getTraits()[i] = temp;

        }

    }

    //Mutation
    private void mutation() {
        Random rn = new Random();

        //Select a random mutation point
        int mutationPoint = rn.nextInt(population.getIndividuals()[0].getTraits().length);

        //Flip values at the mutation point
        if (fittest.getTraits()[mutationPoint] == 0) {
            fittest.getTraits()[mutationPoint] = 1;
        } else {
            fittest.getTraits()[mutationPoint] = 0;
        }

        mutationPoint = rn.nextInt(population.getIndividuals()[0].getTraits().length);

        if (secondFittest.getTraits()[mutationPoint] == 0) {
            secondFittest.getTraits()[mutationPoint] = 1;
        } else {
            secondFittest.getTraits()[mutationPoint] = 0;
        }
    }

    //Get fittest offspring
    private Individual getFittestOffspring() {
        if (fittest.getFitness() > secondFittest.getFitness()) {
            return fittest;
        }
        return secondFittest;
    }


    //Replace least fittest individual from most fittest offspring
    private void addFittestOffspring() {

        //Update fitness values of offspring
        fittest.calcFitness();
        secondFittest.calcFitness();

        //Get index of least fit individual
        int leastFittestIndex = population.getLeastFittestIndex();

        //Replace least fittest individual from most fittest offspring
        population.getIndividuals()[leastFittestIndex] = getFittestOffspring();
    }

}

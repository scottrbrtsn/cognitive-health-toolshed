package com.cognitive.health.toolshed.services.impl;

import com.cognitive.health.toolshed.services.IWekaClassifierService;
import org.springframework.stereotype.Service;
import weka.classifiers.Classifier;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.evaluation.Evaluation;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

import java.util.ArrayList;
import java.util.List;

@Service
public class WekaClassifierService implements IWekaClassifierService {

    @Override
    public double[] runClassifierExample() throws Exception{
        //1
        Instances isTrainingSet = setupTrainingSet();

        Instances isTestingSet = setupTestingSet();


        // Create a naïve bayes classifier
        Classifier cModel = new NaiveBayes();
        cModel.buildClassifier(isTrainingSet);

        //3 Test the classifier
        // Test the model
        Evaluation eTest = new Evaluation(isTrainingSet);
        eTest.evaluateModel(cModel, isTestingSet);

        // Print the result à la Weka explorer:
        String strSummary = eTest.toSummaryString();
        System.out.println(strSummary);

        // Get the confusion matrix
        double[][] cmMatrix = eTest.confusionMatrix();

        //4 use the classifier
        // Specify that the instance belong to the training set
        // in order to inherit from the set description
        Instance iUse = setupModelSet();
        iUse.setDataset(isTrainingSet);

        // Get the likelihood of each classes
        // fDistribution[0] is the probability of being “positive”
        // fDistribution[1] is the probability of being “negative”
        return cModel.distributionForInstance(iUse);
    }

    private Instances setupTrainingSet(){
        ArrayList<Attribute> fvWekaAttributes = setupAttributes();

        //2 train a classifier
        // Create an empty training set
        Instances isTrainingSet = new Instances("Rel", fvWekaAttributes, 10);

        // Set class index
        isTrainingSet.setClass(fvWekaAttributes.get(3));

        // Create the instance
        Instance iExample = new DenseInstance(4);
        iExample.setValue(fvWekaAttributes.get(0), 1.0);
        iExample.setValue(fvWekaAttributes.get(1), 0.5);
        iExample.setValue(fvWekaAttributes.get(2), "gray");
        iExample.setValue(fvWekaAttributes.get(3), "positive");

        // add the instance
        isTrainingSet.add(iExample);

        return isTrainingSet;
    }

    private Instances setupTestingSet(){
        ArrayList<Attribute> fvWekaAttributes = setupAttributes();

        //2 train a classifier
        // Create an empty training set
        Instances isTestingSet = new Instances("Rel", fvWekaAttributes, 10);

        // Create the instance
        Instance iExample = new DenseInstance(4);
        iExample.setValue(fvWekaAttributes.get(0), .0);
        iExample.setValue(fvWekaAttributes.get(1), 0.0);
        iExample.setValue(fvWekaAttributes.get(2), "blue");
        iExample.setValue(fvWekaAttributes.get(3), "negative");

        isTestingSet.setClass(fvWekaAttributes.get(3));

        // add the instance
        isTestingSet.add(iExample);

        return isTestingSet;
    }

    private Instance setupModelSet() {
        ArrayList<Attribute> fvWekaAttributes = setupAttributes();
        // Create the instance
        Instance iExample = new DenseInstance(3);
        iExample.setValue(fvWekaAttributes.get(0), .5);
        iExample.setValue(fvWekaAttributes.get(1), 0.25);
        iExample.setValue(fvWekaAttributes.get(2), "black");

        return iExample;
    }

    private ArrayList<Attribute> setupAttributes(){
        // Declare two numeric attributes
        Attribute attribute1 = new Attribute("firstNumeric", 0);

        Attribute attribute2 = new Attribute("secondNumeric", 1);

        // Declare a nominal attribute along with its values
        List<String> fvNominalVal = new ArrayList<>(3);
        fvNominalVal.add("blue");
        fvNominalVal.add("gray");
        fvNominalVal.add("black");
        Attribute attribute3 = new Attribute("aNominal", fvNominalVal, 2);

        // Declare the class attribute along with its values
        List<String> fvClassVal = new ArrayList<>(2);
        fvClassVal.add("positive");
        fvClassVal.add("negative");
        Attribute ClassAttribute = new Attribute("theClass", fvClassVal, 3);

        // Declare the feature vector
        ArrayList<Attribute> fvWekaAttributes = new ArrayList<>(4);
        fvWekaAttributes.add(attribute1);
        fvWekaAttributes.add(attribute2);
        fvWekaAttributes.add(attribute3);
        fvWekaAttributes.add(ClassAttribute);

        return fvWekaAttributes;

    }
}

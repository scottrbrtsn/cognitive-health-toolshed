package com.cognitive.health.toolshed.domain.viewmodels;

import com.cognitive.health.toolshed.domain.surveys.Anxiety;
import com.cognitive.health.toolshed.domain.surveys.Depression;
import com.cognitive.health.toolshed.domain.surveys.Flow;
import com.cognitive.health.toolshed.domain.surveys.Mindfulness;
import lombok.Data;

import java.util.List;

@Data
public class UserData {

    public String userName;

    public List <Flow> flowList;

    public List <Mindfulness> mindfulList;

    public List <Anxiety> anxietyList;

    public List <Depression> depressionList;

    //use all of the above to estimate the student's learning curve.
    public List<String> learningPotential;

}

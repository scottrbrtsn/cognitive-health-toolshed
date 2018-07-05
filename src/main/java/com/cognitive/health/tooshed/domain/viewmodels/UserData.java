package com.cognitive.health.tooshed.domain.viewmodels;

import com.cognitive.health.tooshed.domain.surveys.Flow;
import lombok.Data;

import java.util.List;

@Data
public class UserData {

    public String userName;

    public List <Flow> flowList;

    //use all of the above to estimate the student's learning curve.
    public List<String> learningPotential;

}

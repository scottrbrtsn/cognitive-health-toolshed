package com.cognitive.health.toolshed.services.impl;

import com.cognitive.health.toolshed.domain.viewmodels.UserData;
import com.cognitive.health.toolshed.ras.IAnxietyRepository;
import com.cognitive.health.toolshed.ras.IDepressionRepository;
import com.cognitive.health.toolshed.ras.IFlowRepository;
import com.cognitive.health.toolshed.ras.IMindfulnessRepository;
import com.cognitive.health.toolshed.services.IUserDataService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDataService implements IUserDataService {

    @Autowired
    IFlowRepository flowRepository;

    @Autowired
    IDepressionRepository depressionRepository;

    @Autowired
    IAnxietyRepository anxietyRepository;

    @Autowired
    IMindfulnessRepository mindfulnessRepository;

    /**
     * getStudentData aggregates all the data into a single object for viewing purposes
     *
     * @param userName
     * @return UserData contains the aggregation
     */
    @Override
    @HystrixCommand(fallbackMethod = "temp")
    public UserData getUserData(String userName){
        UserData userData = new UserData();
        userData.setUserName(userName);
        userData.setFlowList(flowRepository.findByUserName(userName));
        userData.setMindfulList(mindfulnessRepository.findByUserName(userName));
        userData.setAnxietyList(anxietyRepository.findByUserName(userName));
        userData.setDepressionList(depressionRepository.findByUserName(userName));
        return userData;
    }

    @Override
    public UserData temp (String userName){
        return new UserData();
    }

}

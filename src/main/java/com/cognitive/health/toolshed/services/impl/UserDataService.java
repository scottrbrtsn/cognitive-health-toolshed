package com.cognitive.health.toolshed.services.impl;

import com.cognitive.health.toolshed.domain.viewmodels.UserData;
import com.cognitive.health.toolshed.ras.IFlowRepository;
import com.cognitive.health.toolshed.services.IUserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDataService implements IUserDataService {

    @Autowired
    IFlowRepository flowRepository;

    /**
     * getStudentData aggregates all the data into a single object for viewing purposes
     *
     * @param userName
     * @return UserData contains the aggregation
     */
    @Override
    public UserData getUserData(String userName){
        UserData userData = new UserData();
        userData.setUserName(userName);
        userData.setFlowList(flowRepository.findByUserName(userName));

        return userData;
    }

}

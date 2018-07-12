package com.cognitive.health.toolshed.services.impl;

import com.cognitive.health.toolshed.domain.UserInfo;
import com.cognitive.health.toolshed.ras.IUserInfoRepository;
import com.cognitive.health.toolshed.services.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Contains logic to manipulate controller requests into calls to the database and data from the database into a desirable form
 * @author matthewwolff
 *
 */
@Service
public class UserInfoService implements IUserInfoService {

    @Autowired
    private IUserInfoRepository userInfoRepository;

    public UserInfoService(){

    }

    @Override
    public List <UserInfo> getAllUserInfo(){
        return userInfoRepository.findAll();
    }

    @Override
    public UserInfo saveUserInfo(UserInfo userInfo){
        return userInfoRepository.save(userInfo);
    }

}



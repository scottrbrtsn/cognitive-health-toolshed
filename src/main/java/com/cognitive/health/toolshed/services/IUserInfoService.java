package com.cognitive.health.toolshed.services;

import com.cognitive.health.toolshed.domain.UserInfo;

import java.util.List;

public interface IUserInfoService {

    List <UserInfo> getAllUserInfo();

    UserInfo saveUserInfo(UserInfo userInfo);

}

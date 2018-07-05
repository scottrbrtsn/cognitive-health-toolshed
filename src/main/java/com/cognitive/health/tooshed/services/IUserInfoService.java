package com.cognitive.health.tooshed.services;

import com.cognitive.health.tooshed.domain.UserInfo;

import java.util.List;

public interface IUserInfoService {

    List <UserInfo> getAllUserInfo();

    UserInfo saveUserInfo(UserInfo userInfo);

}

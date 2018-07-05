package com.cognitive.health.tooshed.controllers;


import com.cognitive.health.tooshed.domain.UserInfo;
import com.cognitive.health.tooshed.services.impl.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/userInfo")
class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<UserInfo> getUserInfo() {
        return userInfoService.getAllUserInfo();
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody UserInfo saveUserInfo(@RequestBody UserInfo userInfo,  HttpServletRequest request) {
        userInfo.setIp(request.getRemoteAddr());
        userInfo.setUser(request.getRemoteUser());
        userInfo.setHost(request.getRemoteHost());
        return userInfoService.saveUserInfo(userInfo);
    }


}

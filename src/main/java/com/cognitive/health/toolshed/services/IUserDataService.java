package com.cognitive.health.toolshed.services;

import com.cognitive.health.toolshed.domain.viewmodels.UserData;

public interface IUserDataService {

    UserData getUserData(String userName);

}

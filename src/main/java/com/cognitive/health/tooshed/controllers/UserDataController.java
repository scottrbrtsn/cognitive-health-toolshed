package com.cognitive.health.tooshed.controllers;

import com.cognitive.health.tooshed.domain.viewmodels.UserData;
import com.cognitive.health.tooshed.services.IUserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/userData")
public class UserDataController {

    @Autowired
    private IUserDataService userDataService;

    @RequestMapping(value="/{userName}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<UserData> getUserData(@PathVariable String userName) {
        return new ResponseEntity<>(userDataService.getUserData(userName), HttpStatus.OK);
    }

}
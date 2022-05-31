package com.learn.springboot.learnspringboot.controller;

import com.learn.springboot.learnspringboot.entity.Registration;
import com.learn.springboot.learnspringboot.model.RegistrationModel;
import com.learn.springboot.learnspringboot.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    public RegistrationService service;

    @PostMapping ("/createUser")
    public Registration createUser (@RequestBody RegistrationModel model) {
        Registration regEn =  service.save(model);
        return regEn;
    }
}

package com.learn.springboot.learnspringboot.model;

import lombok.Data;

@Data
public class RegistrationModel {

    private int userId;
    private String userName;
    private String password;
}
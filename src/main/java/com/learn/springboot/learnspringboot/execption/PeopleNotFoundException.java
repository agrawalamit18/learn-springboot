package com.learn.springboot.learnspringboot.execption;


public class PeopleNotFoundException extends Exception{

    public PeopleNotFoundException(String errorMessage){
        super(errorMessage);
    }
}

package com.learn.springboot.learnspringboot.entity;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    private HttpStatus status;
    private String errorMessage;



}

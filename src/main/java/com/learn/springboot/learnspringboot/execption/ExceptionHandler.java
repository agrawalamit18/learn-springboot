package com.learn.springboot.learnspringboot.execption;

import com.learn.springboot.learnspringboot.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus

public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(PeopleNotFoundException.class)
    public ResponseEntity<ErrorMessage> peopleNotFoundException (PeopleNotFoundException exception, WebRequest web) {

        ErrorMessage error = new ErrorMessage();
        error.setStatus(HttpStatus.NOT_FOUND);
        error.setErrorMessage("Not Found");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }

}

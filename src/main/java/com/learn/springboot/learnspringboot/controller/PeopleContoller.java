package com.learn.springboot.learnspringboot.controller;

import com.learn.springboot.learnspringboot.entity.People;
import com.learn.springboot.learnspringboot.execption.PeopleNotFoundException;
import com.learn.springboot.learnspringboot.service.PeopleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class PeopleContoller {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    public PeopleService people;

    @GetMapping ("/getAllPeople")
    public List<People> getAllPeople () {
        logger.info("Inside getAllPeople");
        return people.getAllPeople();
    }

    @GetMapping ("/addPeople")
    public List<People> addPeople (@RequestParam ("id") int id, @RequestParam ("name") String name) {
        People p = new People();
        p.setId(id);
        p.setName(name);
        people.addPeople(p);
        return people.getAllPeople();
    }

    @GetMapping ("/delete/{id}")
    public List<People> addPeople (@PathVariable("id") int id) throws PeopleNotFoundException {
        people.deleteRecord(id);
        return people.getAllPeople();
    }

}

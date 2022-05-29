package com.learn.springboot.learnspringboot.service;

import com.learn.springboot.learnspringboot.entity.People;
import com.learn.springboot.learnspringboot.execption.PeopleNotFoundException;
import com.learn.springboot.learnspringboot.repository.PeopleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PeopleServiceTest {

    @Autowired
    private PeopleService peopleservice;

    @MockBean
    private PeopleRepository repo;

    @BeforeEach
    public void setup() {
        System.out.println("Running test case - Before setup");
        People people = new People();
        people.setId(1);
        people.setName("Test");
        Optional<People> pl = Optional.of(people);
        Mockito.when(peopleservice.findById(1)).thenReturn(pl);
    }

    @Test
    public void findByIdTest() {
        Optional<People> peoples = peopleservice.findById(1);
        People p = null;
        if(peoples.isPresent()) {
            p = peoples.get();
        }
        assertEquals(1, p.id);
    }

    @Test
    public void noRecordFound() {
        List<People> peoples = peopleservice.getAllPeople();
        assertEquals(0, peoples.size());
    }

    @Test
    public void saveAndConfirmSave() {
        People people = new People();
        people.setId(1);
        people.setName("Amit");
        peopleservice.addPeople(people);
        List<People> peoples = peopleservice.getAllPeople();
        assertEquals(1, peoples.size());
    }

    @Test
    public void deleteRecord() {
        try {
            peopleservice.deleteRecord(1);
        } catch (PeopleNotFoundException e) {
            e.printStackTrace();
        }
        List<People> peoples = peopleservice.getAllPeople();
        assertEquals(0, peoples.size());
    }
}
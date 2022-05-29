package com.learn.springboot.learnspringboot.service;

import com.learn.springboot.learnspringboot.entity.People;
import com.learn.springboot.learnspringboot.execption.PeopleNotFoundException;
import com.learn.springboot.learnspringboot.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    @Autowired
    public PeopleRepository repository;

    public List<People> getAllPeople()
    {
        List<People> peoples = new ArrayList<People>();
        repository.findAll().forEach(people -> peoples.add(people));
        return peoples;
    }

    public Optional<People> findById(int id) {
        return repository.findById(id);
    }

    public List<People> addPeople(People obj) {
        repository.save(obj);
        List<People> peoples = new ArrayList<People>();
        repository.findAll().forEach(people -> peoples.add(people));
        return peoples;
    }
    public List<People> deleteRecord(int id) throws PeopleNotFoundException {
        Optional<People> p = repository.findById(id);
        if(!p.isPresent()) {
            throw new PeopleNotFoundException("Not found");
        }
        repository.deleteById(id);
        List<People> peoples = new ArrayList<People>();
        repository.findAll().forEach(people -> peoples.add(people));
        return peoples;
    }
}
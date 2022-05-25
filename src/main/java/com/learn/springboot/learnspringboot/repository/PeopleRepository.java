package com.learn.springboot.learnspringboot.repository;

import com.learn.springboot.learnspringboot.entity.People;
import org.springframework.data.repository.CrudRepository;

public interface PeopleRepository extends CrudRepository<People, Integer>
{

}
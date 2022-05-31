package com.learn.springboot.learnspringboot.repository;

import com.learn.springboot.learnspringboot.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

}

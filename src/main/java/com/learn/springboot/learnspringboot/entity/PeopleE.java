package com.learn.springboot.learnspringboot.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PeopleE {

    @Column(name = "first_name", length = 50, nullable = false, unique = false)
    public String firstName;

    @Column (name = "last_name", length = 50, nullable = false, unique = false)
    public String lastName;

}

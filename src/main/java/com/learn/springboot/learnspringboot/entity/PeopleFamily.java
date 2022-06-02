package com.learn.springboot.learnspringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "people_family")
public class PeopleFamily {

    @Id
    private int family_id;

    private String full_name;

    private String relation;
}

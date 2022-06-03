package com.learn.springboot.learnspringboot.controller;

import com.learn.springboot.learnspringboot.entity.People;
import com.learn.springboot.learnspringboot.execption.PeopleNotFoundException;
import com.learn.springboot.learnspringboot.repository.PeopleRepository;
import com.learn.springboot.learnspringboot.service.PeopleService;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.DataFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.Resource;

import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;


import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class PeopleContoller {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    public PeopleService people;

    @Autowired
    public PeopleRepository repository;

    @Value("classpath:people.graphqls")
    private Resource schemaResource;

    private GraphQL graphQL;

    @PostConstruct
    public void loadSchema() throws IOException {
        File file = schemaResource.getFile();
        TypeDefinitionRegistry registry = new SchemaParser().parse(file);
        RuntimeWiring bw = buildWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(registry, bw);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildWiring() {
        DataFetcher<List<People>> getAll = data -> {
            return (List<People>) repository.findAll();
        };

        DataFetcher<People> findById = data -> {
            return repository.findById(data.getArgument("id")).get();
        };

        return RuntimeWiring.newRuntimeWiring().type("Query",
                        typeWriting -> typeWriting.dataFetcher("getAll", getAll).dataFetcher("findById", findById))
                .build();

    }

    @GetMapping ("/getAllPeople")
    public List<People> getAllPeople () {
        logger.info("Inside getAllPeople");
        return people.getAllPeople();
    }

    @PostMapping("/addPeople")
    public List<People> addPeople (@RequestBody People p) {
        people.addPeople(p);
        return people.getAllPeople();
    }

    @GetMapping ("/delete/{id}")
    public List<People> addPeople (@PathVariable("id") int id) throws PeopleNotFoundException {
        people.deleteRecord(id);
        return people.getAllPeople();
    }

    @PostMapping("/getAll")
    public ResponseEntity<Object> getAll(@RequestBody String query) {
        ExecutionResult result = graphQL.execute(query);
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findPersonById(@RequestBody String query) {
        ExecutionResult result = graphQL.execute(query);
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }
}
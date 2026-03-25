package com.example.safetynet.controllers;

import com.example.safetynet.models.Person;
import com.example.safetynet.services.PersonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping("/person")
    public  void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }
}

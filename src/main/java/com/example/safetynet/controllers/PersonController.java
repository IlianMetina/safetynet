package com.example.safetynet.controllers;

import com.example.safetynet.models.Person;
import com.example.safetynet.services.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping("/person/add")
    public  void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @PatchMapping("/person/update")
    public void updatePerson(@RequestBody Person person) { personService.updatePerson(person); }

    @DeleteMapping("/person/delete")
    public void deletePerson(
            @RequestParam String firstName,
            @RequestParam String lastName
    ){
        personService.deletePerson(firstName, lastName);
    }

    @GetMapping("/person/get")
    public ArrayList<Person> getPersons(){
        return personService.getPersons();
    }

    @GetMapping("/communityEmail")
    public ArrayList<String> getEmailsByCity(@RequestParam String city){
        return personService.getEmailsByCity(city);
    }
}

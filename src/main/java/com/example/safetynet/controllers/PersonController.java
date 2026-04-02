package com.example.safetynet.controllers;

import com.example.safetynet.dto.ChildAlertDTO;
import com.example.safetynet.dto.FireDTO;
import com.example.safetynet.models.Person;
import com.example.safetynet.dto.PersonInfoDTO;
import com.example.safetynet.services.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    /* ============ CRUD ============ */

    @PostMapping("/person/add")
    public  void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping("/person/get")
    public ArrayList<Person> getPersons(){
        return personService.getPersons();
    }

    @PutMapping("/person/update")
    public void updatePerson(@RequestBody Person person) { personService.updatePerson(person); }

    @DeleteMapping("/person/delete")
    public void deletePerson(
            @RequestParam String firstName,
            @RequestParam String lastName
    ){
        personService.deletePerson(firstName, lastName);
    }

    /* ============ CRUD ============ */

    /* ============ ENDPOINTS ============ */

    @GetMapping("/communityEmail")
    public ArrayList<String> getEmailsByCity(@RequestParam String city){
        return personService.getEmailsByCity(city);
    }

    @GetMapping("/personInfo")
    public ArrayList<PersonInfoDTO> findPersonsInfosByLastAndFirstName(
        @RequestParam String lastName,
        @RequestParam String firstName
    ){
        return personService.findPersonsInfosByLastAndFirstName(lastName, firstName);
    }

    @GetMapping("/childAlert")
    public ArrayList<ChildAlertDTO> getChildrenByAddress(@RequestParam String address){
        return this.personService.getChildrenByAddress(address);
    }

    /* ============ ENDPOINTS ============ */


}

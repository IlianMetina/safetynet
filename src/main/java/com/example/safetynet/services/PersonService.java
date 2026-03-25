package com.example.safetynet.services;

import com.example.safetynet.models.Person;
import com.example.safetynet.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public ArrayList<Person> getPersons(){
            return personRepository.findAll();
    }

    public void addPerson(Person person) {
            personRepository.save(person);
    }

    public void updatePerson(Person person){
        personRepository.update(person);
    }

    public void deletePerson(String firstName, String lastName){}

//    public List<Person> findByAddress(String address){
//
//    }
//
//    public List<Person> findByLastName(String lastName){
//
//    }
//
//    public List<String> findEmailsByCity(String city){
//
//    }
}

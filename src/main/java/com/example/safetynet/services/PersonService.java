package com.example.safetynet.services;

import com.example.safetynet.models.Person;
import com.example.safetynet.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class PersonService {

    private final DataService dataService;
    private final PersonRepository personRepository;

    public PersonService(DataService dataService, PersonRepository personRepository){
        this.dataService = dataService;
        this.personRepository = personRepository;
    }

    public ArrayList<Person> getPersons(){
            return personRepository.findAll();
    }

    public void addPerson(Person person) {
            personRepository.save(person);
    }

    public void updatePerson(Person person){
//        try {
//            ArrayList<Person> p = dataService.getData().getPersons();
//
//            for (int i = 0; i < p.size(); i++){
//                if(p.get(i).getFirstName().equals(person.getFirstName()) && p.get(i).getLastName().equals(person.getLastName())){
//                    p.set(i, person);
//                }
//            }
//        }catch (IOException e){
//            throw new RuntimeException("Erreur lors de la mise à jour d'une personne");
//        }
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

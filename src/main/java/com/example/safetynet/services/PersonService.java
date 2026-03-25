package com.example.safetynet.services;

import com.example.safetynet.models.Data;
import com.example.safetynet.models.Person;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private final DataService dataService;

    public PersonService(DataService dataService){
        this.dataService = dataService;
    }

    public void addPerson(Person person){
        try {
            Data d = dataService.getData();
            if (d.getPersons() == null){
                d.setPersons(new ArrayList<>());
            }
            d.getPersons().add(person);
        } catch (IOException e){
            throw new RuntimeException("Erreur lors de l'ajout d'une personne", e);
        }
    }

    public void updatePerson(Person person) throws IOException{
        ArrayList<Person> p = dataService.getData().getPersons();
        for (int i = 0; i < p.size(); i++){
            if(p.get(i).getFirstName().equals(person.getFirstName()) && p.get(i).getLastName().equals(person.getLastName())){
                p.set(i, person);
            }
        }
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

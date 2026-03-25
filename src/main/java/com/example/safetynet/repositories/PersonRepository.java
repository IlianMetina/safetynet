package com.example.safetynet.repositories;

import com.example.safetynet.models.Data;
import com.example.safetynet.models.Person;
import com.example.safetynet.services.DataService;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;

@Repository
public class PersonRepository {

    private final ArrayList<Person> persons;

    public PersonRepository(DataService dataService) throws IOException{
        Data data = dataService.getData();
        if(data.getPersons() == null){
            this.persons = new ArrayList<>();
        }else{
            this.persons = data.getPersons();
        }
    }

    public ArrayList<Person> findAll(){
        return this.persons;
    }

    public void save(Person person) throws IOException{
        this.persons.add(person);
    }

    public void update(Person person) throws IOException{

    }
}

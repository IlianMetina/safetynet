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

    public void save(Person person){
        this.persons.add(person);
    }

    public void update(Person person){
        for (int i = 0; i < persons.size(); i++){
            if(persons.get(i).getFirstName().equals(person.getFirstName()) && persons.get(i).getLastName().equals(person.getLastName())){
                persons.set(i, person);
            }
        }
    }

    public void delete(String firstName, String lastName){
        for(int i = 0; i < persons.size(); i++){
            if(persons.get(i).getFirstName().equals(firstName) && persons.get(i).getLastName().equals(lastName)){
                persons.remove(persons.get(i));
                break;
            }
        }
    }

    public ArrayList<String> getEmailsByCity(String city){
        ArrayList<String> personsEmail = new ArrayList<>();
        for (int i = 0; i < persons.size(); i++){
            if(persons.get(i).getCity().equals(city)){
                String email = persons.get(i).getEmail();
                personsEmail.add(email);
            }
        }
        return personsEmail;
    }
}

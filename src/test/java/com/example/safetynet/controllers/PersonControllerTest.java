package com.example.safetynet.controllers;

import com.example.safetynet.models.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PersonControllerTest {

    @Autowired
    private PersonController personController;

    /* ===== CREATE TEST ===== */
    @Test
    public void addPersonControllerTest(){

        boolean isAdded = false;
        Person personToAdd = buildTestPerson();
        personController.addPerson(personToAdd);
        ArrayList<Person> persons = personController.getPersons();
        for (int i = 0; i < persons.size(); i++){
            if(
                    persons.get(i).getFirstName().equals(personToAdd.getFirstName())
                    &&
                    persons.get(i).getLastName().equals(personToAdd.getLastName())
            ){
                isAdded = true;
            }
        }

        assertTrue(isAdded);
    }

    /* ===== READ TEST ===== */
    @Test
    public void getPersonsControllerTest(){
        ArrayList<Person> persons = personController.getPersons();
        assertNotNull(persons);
        assertFalse(persons.isEmpty());
        for (int i = 0; i < persons.size(); i++){

            assertNotNull(persons.get(i).getFirstName());
        }
    }

    /* ===== UPDATE TEST ===== */
    @Test
    public void updatePersonControllerTest(){
        ArrayList<Person> persons = personController.getPersons();
        int selectIndex = 1;
        Person selectedPerson = persons.get(selectIndex);
        persons.get(selectIndex).setFirstName("newname");
        persons.get(selectIndex).setLastName("lastname");

    }

    /* ===== DELETE TEST ===== */
    @Test
    public void deletePersonControllerTest(){

    }

    private Person buildTestPerson(){
        Person person = new Person();
        person.setAddress("123 Rue");
        person.setEmail("aaa@yopmail.com");
        person.setCity("Paris");
        person.setPhone("0606060606");
        person.setFirstName("jean");
        person.setLastName("valjean");
        person.setZip("75000");

        return person;
    }


}

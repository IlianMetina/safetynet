package com.example.safetynet.services;

import com.example.safetynet.models.Person;
import com.example.safetynet.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PersonServiceTest {

    private Person person;

//    @Autowired
//    private PersonRepository personRepo;

//    private Person buildTestPerson(){
//        Person person = new Person();
//        person.setAddress("123 Rue");
//        person.setEmail("aaa@yopmail.com");
//        person.setCity("Paris");
//        person.setPhone("0606060606");
//        person.setFirstName("jean");
//        person.setLastName("valjean");
//        person.setZip("75000");
//
//        return person;
//    }
//
//    public void getPersonsTest(){
//
//
//    }
//
//    @Test
//    public void addPersonTest(){
//
//        Person person = buildTestPerson();
//        Person personAdded = personRepo.save(person);
//        assertNotNull(personAdded);
//        assertEquals("jean", personAdded.getFirstName());
//
//    }

//    public void updatePersonTest(){
//
//        Person person = buildTestPerson();
//        person.setLastName("valjeanjean");
//        Person personAdded;
//
//    }

    public void deletePersonTest(){


    }

}

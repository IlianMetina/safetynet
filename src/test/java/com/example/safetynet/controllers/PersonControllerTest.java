package com.example.safetynet.controllers;

import com.example.safetynet.dto.ChildAlertDTO;
import com.example.safetynet.models.MedicalRecord;
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
    void addPersonControllerTest(){

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
    void getPersonsControllerTest(){
        ArrayList<Person> persons = personController.getPersons();
        assertNotNull(persons);
        assertFalse(persons.isEmpty());
        for (int i = 0; i < persons.size(); i++){

            assertNotNull(persons.get(i).getFirstName());
        }
    }

    /* ===== UPDATE TEST ===== */
    @Test
    void updatePersonControllerTest(){

        ArrayList<Person> persons = personController.getPersons();
        int selectIndex = 1;

        Person originalPerson = persons.get(selectIndex);
        Person modifiedPerson = new Person();

        modifiedPerson.setFirstName(originalPerson.getFirstName());
        modifiedPerson.setLastName(originalPerson.getLastName());

        modifiedPerson.setAddress(originalPerson.getAddress());
        modifiedPerson.setCity(originalPerson.getCity());
        modifiedPerson.setZip(originalPerson.getZip());
        modifiedPerson.setPhone(originalPerson.getPhone());
        modifiedPerson.setEmail(originalPerson.getEmail());

        modifiedPerson.setAddress("new address");

        personController.updatePerson(modifiedPerson);

        Person updatedPerson = personController.getPersons().get(selectIndex);

        assertEquals("new address", updatedPerson.getAddress());
    }

    /* ===== DELETE TEST ===== */
    @Test
    void deletePerson(){

        Person person = buildTestPerson();
        personController.addPerson(person);
        int personSizeBefore = personController.getPersons().size();
        personController.deletePerson(person.getFirstName(), person.getLastName());
        int personSizeAfter = personController.getPersons().size();

        assertEquals(personSizeBefore - 1, personSizeAfter);

    }

    @Test
    void getEmailsByCityTest(){

        String city = "Paris";
        ArrayList<Person> persons = personController.getPersons();
        ArrayList<Person> selectedPersons = new ArrayList<>();
        for (int i = 0; i < persons.size(); i++){
            System.out.println(persons.get(i).getCity());
            if(persons.get(i).getCity().equals(city)){
                selectedPersons.add(persons.get(i));
                System.out.println(persons.get(i).getEmail());
            }
        }

        for (int j = 0; j < selectedPersons.size(); j++){
            System.out.println("=====" + selectedPersons.get(j));
            assertEquals("Paris", selectedPersons.get(j).getCity());
        }
    }

    @Test
    void findPersonsInfosByLastAndFirstNameTest(){
        String firstName = "Tony";
        String lastName = "Cooper";
        ArrayList<Person> persons = personController.getPersons();

        for (int i = 0; i < persons.size(); i++){
            if(
                persons.get(i).getLastName().equals(lastName)
                &&
                persons.get(i).getFirstName().equals(firstName)
            ){
                assertEquals(lastName, persons.get(i).getLastName());
                assertEquals(firstName, persons.get(i).getFirstName());
            }
        }
    }

    @Test
    void getChildrenByAddressTest(){
        String address = "1509 Culver St";
        ArrayList<ChildAlertDTO> children = personController.getChildrenByAddress(address);

        assertNotNull(children);
        assertFalse(children.isEmpty());

        ChildAlertDTO child = children.get(0);
        assertNotNull(child.getFirstName());
        assertTrue(child.getAge() <= 18);
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

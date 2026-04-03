package com.example.safetynet.controllers;

import com.example.safetynet.models.Firestation;
import com.example.safetynet.models.MedicalRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FirestationControllerTest {

    @Autowired
    private FirestationController firestationController;

    @Test
    public void getMedicalRecordsControllerTest(){
        ArrayList<Firestation> firestations = firestationController.findAllFirestations();
        assertNotNull(firestations);
        assertFalse(firestations.isEmpty());
        for (int i = 0; i < firestations.size(); i++){

            assertNotNull(firestations.get(i).getAddress());
        }
    }

    @Test
    public void addFirestationControllerTest(){

        boolean isAdded = false;
        Firestation firestationToAdd = buildFirestationControllerTest();
        firestationController.addFirestation(firestationToAdd);
        ArrayList<Firestation> allFirestations = firestationController.findAllFirestations();
        for (int i = 0; i < allFirestations.size(); i++){
            if(
                    allFirestations.get(i).getAddress().equals(firestationToAdd.getAddress())
                    &&
                    allFirestations.get(i).getStation().equals(firestationToAdd.getStation())
            ){
                isAdded = true;
            }
        }

        assertTrue(isAdded);
    }

    public static Firestation buildFirestationControllerTest(){
        Firestation firestationToAdd = new Firestation();
        firestationToAdd.setAddress("123 Rue Trivoli");
        firestationToAdd.setStation("9");

        return firestationToAdd;
    }
}

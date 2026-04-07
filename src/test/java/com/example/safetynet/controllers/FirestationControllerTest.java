package com.example.safetynet.controllers;

import com.example.safetynet.dto.*;
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
    void getMedicalRecordsControllerTest(){
        ArrayList<Firestation> firestations = firestationController.findAllFirestations();
        assertNotNull(firestations);
        assertFalse(firestations.isEmpty());
        for (int i = 0; i < firestations.size(); i++){

            assertNotNull(firestations.get(i).getAddress());
        }
    }

    @Test
    void addFirestationControllerTest(){

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

    @Test
    void updateFirestationControllerTest(){

        ArrayList<Firestation> firestations = firestationController.findAllFirestations();
        int selectIndex = 1;

        Firestation originalFirestation = firestations.get(selectIndex);

        Firestation modifiedFirestation = new Firestation();

        modifiedFirestation.setAddress(originalFirestation.getAddress());

        modifiedFirestation.setStation("99");

        firestationController.updateFirestation(modifiedFirestation);

        Firestation updatedFirestation = firestationController.findAllFirestations().get(selectIndex);

        assertEquals("99", updatedFirestation.getStation());
    }

    @Test
    void deleteFirestationControllerTest(){

        Firestation firestation = buildFirestationControllerTest();
        firestationController.addFirestation(firestation);
        int firestationSizeBefore = firestationController.findAllFirestations().size();
        firestationController.deleteFirestation(firestation.getAddress());
        int firestationSizeAfter = firestationController.findAllFirestations().size();

        assertEquals(firestationSizeBefore - 1, firestationSizeAfter);

    }

    @Test
    void getPhonesByCasernsTest(){
        ArrayList<String> phones = firestationController.getPhonesByCaserns("1");

        assertEquals(4, phones.size());

        assertTrue(phones.contains("841-874-6512"));
        assertTrue(phones.contains("841-874-8547"));
        assertTrue(phones.contains("841-874-7462"));
        assertTrue(phones.contains("841-874-7784"));
    }

    @Test
    void getPersonsByStationTest(){

        FirestationCoverageDTO result = firestationController.getPersonsByStationNumber("1");

        assertNotNull(result);
        assertNotNull(result.getPersons());
        assertFalse(result.getPersons().isEmpty());

        for (int i = 0; i < result.getPersons().size(); i++){

            FirestationPersonDTO dto = result.getPersons().get(i);
            assertNotNull(dto.getFirstName());
            assertNotNull(dto.getLastName());
            assertNotNull(dto.getAddress());
            assertNotNull(dto.getPhone());
        }

        assertTrue(result.getAdults() >= 0);
        assertTrue(result.getChildren() >= 0);
    }

    @Test
    void getFloodByStationsTest(){

        ArrayList<String> stations = new ArrayList<>();
        stations.add("1");

        ArrayList<FloodPersonDTO> result = firestationController.getFloodByStations(stations);

        assertNotNull(result);
        assertFalse(result.isEmpty());

        for (int i = 0; i < result.size(); i++) {
            FloodPersonDTO dto = result.get(i);

            assertNotNull(dto.getAddress());
            assertNotNull(dto.getLastName());
            assertNotNull(dto.getPhone());

            assertNotNull(dto.getAge());
            assertNotNull(dto.getMedications());
            assertNotNull(dto.getAllergies());
        }

    }

    @Test
    void getResidentsByAddressTest(){

        FireDTO result = firestationController.getResidentsByAddress("1509 Culver St");
        assertNotNull(result);

        assertNotNull(result.getStationNumber());
        assertNotNull(result.getPersons());

        assertFalse(result.getPersons().isEmpty());

        for (int i = 0; i < result.getPersons().size(); i++){

            FirePersonAddressDTO dto = result.getPersons().get(i);
            assertNotNull(dto.getLastName());
            assertNotNull(dto.getAge());
            assertNotNull(dto.getPhone());
            assertNotNull(dto.getMedications());
            assertNotNull(dto.getAllergies());
        }
    }

    public static Firestation buildFirestationControllerTest(){
        Firestation firestationToAdd = new Firestation();
        firestationToAdd.setAddress("123 Rue Trivoli");
        firestationToAdd.setStation("9");

        return firestationToAdd;
    }
}

package com.example.safetynet.controllers;

import com.example.safetynet.models.MedicalRecord;
import com.example.safetynet.models.Person;
import com.example.safetynet.utils.UtilsTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MedicalRecordControllerTest {


    @Autowired
    private MedicalRecordController medicalRecordController;

    @Test
    public void getMedicalRecordsControllerTest(){
        ArrayList<MedicalRecord> medicalRecords = medicalRecordController.getMedicalRecords();
        assertNotNull(medicalRecords);
        assertFalse(medicalRecords.isEmpty());
        for (int i = 0; i < medicalRecords.size(); i++){

            assertNotNull(medicalRecords.get(i).getFirstName());
        }
    }

    @Test
    public void addMedicalRecordTest(){
        boolean isAdded = false;
        MedicalRecord singleMedicalRecord = buildMedicalRecordTest();
        medicalRecordController.addRecord(singleMedicalRecord);
        ArrayList<MedicalRecord> allMedicalRecords = medicalRecordController.getMedicalRecords();
        for (int i = 0; i < allMedicalRecords.size(); i++){
            if(
                    allMedicalRecords.get(i).getFirstName().equals(singleMedicalRecord.getFirstName())
                    &&
                    allMedicalRecords.get(i).getLastName().equals(singleMedicalRecord.getLastName())
            ){
                isAdded = true;
            }
        }

        assertTrue(isAdded);
    }

    @Test
    public void updateMedicalRecordTest(){


    }

    @Test
    public void deleteMedicalRecordTest(){


    }

    public static MedicalRecord buildMedicalRecordTest(){
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setBirthdate("11/08/2000");
        medicalRecord.setFirstName("Patrick");
        medicalRecord.setLastName("Rival");

        return medicalRecord;
    }
}

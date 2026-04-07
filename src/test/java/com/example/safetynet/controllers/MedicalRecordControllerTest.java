package com.example.safetynet.controllers;

import com.example.safetynet.models.Firestation;
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
    void getMedicalRecordsControllerTest(){
        ArrayList<MedicalRecord> medicalRecords = medicalRecordController.getMedicalRecords();
        assertNotNull(medicalRecords);
        assertFalse(medicalRecords.isEmpty());
        for (int i = 0; i < medicalRecords.size(); i++){

            assertNotNull(medicalRecords.get(i).getFirstName());
        }
    }

    @Test
    void addMedicalRecordTest(){
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
    void updateMedicalRecordControllerTest(){

        ArrayList<MedicalRecord> medicalRecords = medicalRecordController.getMedicalRecords();
        int selectIndex = 1;

        MedicalRecord originalMedicalRecord = medicalRecords.get(selectIndex);
        MedicalRecord modifiedMedicalRecord = new MedicalRecord();

        modifiedMedicalRecord.setFirstName(originalMedicalRecord.getFirstName());
        modifiedMedicalRecord.setLastName(originalMedicalRecord.getLastName());

        modifiedMedicalRecord.setBirthdate("11/08/2000");
        medicalRecordController.updateRecord(modifiedMedicalRecord);

        MedicalRecord updatedMedicalRecord = medicalRecordController.getMedicalRecords().get(selectIndex);

        assertEquals("11/08/2000", updatedMedicalRecord.getBirthdate());
    }

    @Test
    void deleteMedicalRecord(){

        MedicalRecord medicalRecord = buildMedicalRecordTest();
        medicalRecordController.addRecord(medicalRecord);
        int medicalRecordSizeBefore = medicalRecordController.getMedicalRecords().size();
        medicalRecordController.deleteRecord(medicalRecord.getFirstName(), medicalRecord.getLastName());
        int medicalRecordSizeAfter = medicalRecordController.getMedicalRecords().size();

        assertEquals(medicalRecordSizeBefore - 1, medicalRecordSizeAfter);

    }

    public static MedicalRecord buildMedicalRecordTest(){
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setBirthdate("11/08/2000");
        medicalRecord.setFirstName("Patrick");
        medicalRecord.setLastName("Rival");

        return medicalRecord;
    }
}

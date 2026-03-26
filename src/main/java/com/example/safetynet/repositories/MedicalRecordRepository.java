package com.example.safetynet.repositories;

import com.example.safetynet.models.Data;
import com.example.safetynet.models.MedicalRecord;
import com.example.safetynet.models.Person;
import com.example.safetynet.services.DataService;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;

@Repository
public class MedicalRecordRepository {

    private final ArrayList<MedicalRecord> medicalRecords;

    public MedicalRecordRepository(DataService dataService) throws IOException {
        Data data = dataService.getData();
        this.medicalRecords = data.getMedicalrecords();
    }

    public void save(MedicalRecord medicalRecord){
        this.medicalRecords.add(medicalRecord);
    }

    public void update(MedicalRecord medicalRecord){
        for (int i = 0; i < medicalRecords.size(); i++){
            if(medicalRecords.get(i).getFirstName().equals(medicalRecord.getFirstName()) && medicalRecords.get(i).getLastName().equals(medicalRecord.getLastName())){
                medicalRecords.set(i, medicalRecord);
            }
        }
    }

    public void delete(String firstName, String lastName){
        for(int i = 0; i < medicalRecords.size(); i++){
            if(medicalRecords.get(i).getFirstName().equals(firstName) && medicalRecords.get(i).getLastName().equals(lastName)){
                medicalRecords.remove(medicalRecords.get(i));
                break;
            }
        }
    }

    public ArrayList<MedicalRecord> findAll(){
        return this.medicalRecords;
    }
}

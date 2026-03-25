package com.example.safetynet.repositories;

import com.example.safetynet.models.Data;
import com.example.safetynet.models.MedicalRecord;
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

    public ArrayList<MedicalRecord> findAll(){
        return this.medicalRecords;
    }
}

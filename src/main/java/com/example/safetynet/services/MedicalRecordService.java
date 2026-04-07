package com.example.safetynet.services;

import com.example.safetynet.models.MedicalRecord;
import com.example.safetynet.repositories.MedicalRecordRepository;
import com.example.safetynet.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MedicalRecordService {

    private final MedicalRecordRepository medicalRepo;

    public MedicalRecordService(MedicalRecordRepository medicalRepository){
        this.medicalRepo = medicalRepository;
    }

    public void addRecord(MedicalRecord medicalRecord){
        medicalRepo.save(medicalRecord);
    }

    public ArrayList<MedicalRecord> getRecords(){
        return medicalRepo.findAll();
    }

    public void updateRecord(MedicalRecord medicalRecord){
        medicalRepo.update(medicalRecord);
    }

    public void deleteRecord(String firstName, String lastName){
        medicalRepo.delete(firstName, lastName);
    }


}

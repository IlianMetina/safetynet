package com.example.safetynet.controllers;

import com.example.safetynet.models.MedicalRecord;
import com.example.safetynet.services.MedicalRecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MedicalRecordController {

    private final MedicalRecordService medicalService;

    public MedicalRecordController(MedicalRecordService medicalService){
        this.medicalService = medicalService;
    }

    @PostMapping("/medical/add")
    public void addRecord(MedicalRecord medicalRecord){
        medicalService.addRecord(medicalRecord);
    }

    @GetMapping("/medical/get")
    public ArrayList<MedicalRecord> medicalRecords(){
        return medicalService.getRecords();
    }
}

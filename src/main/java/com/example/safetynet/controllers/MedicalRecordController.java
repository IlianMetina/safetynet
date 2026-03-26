package com.example.safetynet.controllers;

import com.example.safetynet.models.MedicalRecord;
import com.example.safetynet.services.MedicalRecordService;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/medical/update")
    public void updateRecord(MedicalRecord medicalRecord){
        medicalService.updateRecord(medicalRecord);
    }

    @DeleteMapping("/person/delete")
    public void deletePerson(
            @RequestParam String firstName,
            @RequestParam String lastName
    ){
        medicalService.deleteRecord(firstName, lastName);
    }

    @GetMapping("/medical/get")
    public ArrayList<MedicalRecord> medicalRecords(){
        return medicalService.getRecords();
    }
}

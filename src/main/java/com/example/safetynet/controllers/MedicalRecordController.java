package com.example.safetynet.controllers;

import com.example.safetynet.services.MedicalRecordService;

public class MedicalRecordController {

    private final MedicalRecordService medicalService;

    public MedicalRecordController(MedicalRecordService medicalService){
        this.medicalService = medicalService;
    }

}

package com.example.safetynet.services;

import org.springframework.stereotype.Service;

@Service
public class MedicalRecordService {

    private final DataService dataService;

    public MedicalRecordService(DataService dataService){
        this.dataService = dataService;
    }

}

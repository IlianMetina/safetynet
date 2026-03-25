package com.example.safetynet.services;

import org.springframework.stereotype.Service;

@Service
public class FirestationService {

    private final DataService dataService;

    public FirestationService(DataService dataService){
        this.dataService = dataService;
    }
}

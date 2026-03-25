package com.example.safetynet.controllers;

import com.example.safetynet.services.FirestationService;

public class FirestationController {

    private final FirestationService firestationService;

    public FirestationController(FirestationService firestationService){
        this.firestationService = firestationService;
    }
}

package com.example.safetynet.controllers;

import com.example.safetynet.services.FirestationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class FirestationController {

    private final FirestationService firestationService;

    public FirestationController(FirestationService firestationService){
        this.firestationService = firestationService;
    }

    @GetMapping("firestation/get")
    public ArrayList<String> getPhonesByCaserns(@RequestParam String station){
        return this.firestationService.getPhonesByCaserns(station);
    }
}

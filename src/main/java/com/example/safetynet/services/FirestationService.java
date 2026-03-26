package com.example.safetynet.services;

import com.example.safetynet.repositories.FirestationRepository;
import org.springframework.stereotype.Service;

@Service
public class FirestationService {

    private final FirestationRepository firestationRepository;
    public FirestationService(FirestationRepository firestationRepository){
        this.firestationRepository = firestationRepository;
    }
}

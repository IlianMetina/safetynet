package com.example.safetynet.services;

import com.example.safetynet.repositories.FirestationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FirestationService {

    private final FirestationRepository firestationRepository;
    public FirestationService(FirestationRepository firestationRepository){
        this.firestationRepository = firestationRepository;
    }

    public ArrayList<String> getPhonesByCaserns(String station){
        return this.firestationRepository.getPhonesByCaserns(station);
    }
}

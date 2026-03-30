package com.example.safetynet.services;

import com.example.safetynet.models.Firestation;
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

    public ArrayList<Firestation> getFirestations(){
        return this.firestationRepository.findAllFirestations();
    }

    public void addFirestation(Firestation firestation){
        if(firestation != null) firestationRepository.addFirestation(firestation);
    }

    public void updateFirestation(Firestation firestation){


    }

    public void deleteFirestation(Firestation firestation){

    }
}

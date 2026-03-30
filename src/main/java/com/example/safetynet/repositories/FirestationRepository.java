package com.example.safetynet.repositories;

import com.example.safetynet.models.Data;
import com.example.safetynet.models.Firestation;
import com.example.safetynet.models.Person;
import com.example.safetynet.services.DataService;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;

@Repository
public class FirestationRepository {

    private final ArrayList<Firestation> firestations;
    private final MedicalRecordRepository medicalRepo;
    private final PersonRepository personRepo;

    public FirestationRepository(DataService dataService, MedicalRecordRepository medicalRepo, PersonRepository personRepo) throws IOException {
        Data data = dataService.getData();
        this.firestations = data.getFirestations();
        this.medicalRepo = medicalRepo;
        this.personRepo = personRepo;
    }

    public ArrayList<Firestation> findAllFirestations(){
        return this.firestations;
    }

    public void addFirestation(Firestation firestation){
        this.firestations.add(firestation);
    }

    public ArrayList<String> getPhonesByCaserns(String station){
        ArrayList<Person> persons = personRepo.findAll();
        ArrayList<String> phones = new ArrayList<>();
        for (int i = 0; i < firestations.size(); i++){
            if(firestations.get(i).getStation().equals(station)){
                String address = firestations.get(i).getAddress();

                for (int j = 0; j < persons.size(); j++){
                    if(persons.get(j).getAddress().equals(address) && !phones.contains(persons.get(j).getPhone())){
                        phones.add(persons.get(j).getPhone());
                    }
                }
            }
        }
        return phones;
    }
}

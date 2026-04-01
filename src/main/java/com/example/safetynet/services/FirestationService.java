package com.example.safetynet.services;

import com.example.safetynet.dto.FirestationCoverageDTO;
import com.example.safetynet.dto.FirestationPersonDTO;
import com.example.safetynet.dto.FloodDTO;
import com.example.safetynet.dto.FloodPersonDTO;
import com.example.safetynet.models.Firestation;
import com.example.safetynet.models.MedicalRecord;
import com.example.safetynet.models.Person;
import com.example.safetynet.repositories.FirestationRepository;
import com.example.safetynet.repositories.MedicalRecordRepository;
import com.example.safetynet.repositories.PersonRepository;
import com.example.safetynet.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Service
public class FirestationService {

    private final FirestationRepository firestationRepository;
    private final PersonRepository personRepository;
    private final MedicalRecordRepository medicalRecordRepository;

    public FirestationService(FirestationRepository firestationRepository, PersonRepository personRepository, MedicalRecordRepository medicalRecordRepository){
        this.firestationRepository = firestationRepository;
        this.personRepository = personRepository;
        this.medicalRecordRepository = medicalRecordRepository;
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

        ArrayList<Firestation> firestations = firestationRepository.findAllFirestations();
        for (int i = 0; i < firestations.size(); i++){
            if(firestations.get(i).getAddress().equals(firestation.getAddress())){
                firestationRepository.updateFirestation(i, firestation);
                break;
            }
        }

    }

    public void deleteFirestation(String address){
        ArrayList<Firestation> firestations = firestationRepository.findAllFirestations();
        for (int i = 0; i < firestations.size(); i++){
            if(firestations.get(i).getAddress().equals(address)){
                firestationRepository.deleteFirestation(i);
                break;
            }
        }
    }



    public ArrayList<FloodPersonDTO> getFloodByStations(ArrayList<String> stations){
        ArrayList<Person> persons = personRepository.findAll();
        ArrayList<MedicalRecord> medicalRecords = medicalRecordRepository.findAll();
        ArrayList<Firestation> firestations = firestationRepository.findAllFirestations();
        ArrayList<FloodPersonDTO> results = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        for (int s = 0; s < stations.size(); s++){
            for (int f = 0; f < firestations.size(); f++){
                if(firestations.get(f).getStation().equals(stations.get(s))){
                    String address = firestations.get(f).getAddress();

                    for (int i = 0; i < persons.size(); i++){

                        if (persons.get(i).getAddress().equals(address)){
                            FloodPersonDTO dto = new FloodPersonDTO();
                            dto.setAddress(address);
                            dto.setLastName(persons.get(i).getLastName());
                            dto.setPhone(persons.get(i).getPhone());

                            for (int j = 0; j < medicalRecords.size(); j++){
                                if(
                                    medicalRecords.get(j).getFirstName().equals(persons.get(i).getFirstName())
                                    &&
                                    medicalRecords.get(j).getLastName().equals(persons.get(i).getLastName())
                                ){
                                    LocalDate birthDate = LocalDate.parse(medicalRecords.get(j).getBirthdate(), formatter);
                                    dto.setAge(Period.between(birthDate, LocalDate.now()).getYears());
                                    dto.setMedications(medicalRecords.get(j).getMedications());
                                    dto.setAllergies(medicalRecords.get(j).getAllergies());
                                    break;
                                }
                            }

                            results.add(dto);
                        }

                    }


                }
            }
        }
        return results;

    }

    public FirestationCoverageDTO getPersonsByStation(String stationNumber){
        ArrayList<Firestation> firestations = firestationRepository.findAllFirestations();
        ArrayList<Person> persons = personRepository.findAll();
        ArrayList<MedicalRecord> medicalRecords = medicalRecordRepository.findAll();

        ArrayList<FirestationPersonDTO> personsDTO = new ArrayList<>();
        int adults = 0;
        int children = 0;

        for (int f = 0; f < firestations.size(); f++){
            if(firestations.get(f).getStation().equals(stationNumber)){
                String address = firestations.get(f).getAddress();

                for (int i = 0; i < persons.size(); i++){

                    if(persons.get(i).getAddress().equals(address)){
                        FirestationPersonDTO dto = new FirestationPersonDTO();
                        dto.setFirstName(persons.get(i).getFirstName());
                        dto.setLastName(persons.get(i).getLastName());
                        dto.setAddress(persons.get(i).getAddress());
                        dto.setPhone(persons.get(i).getPhone());
                        personsDTO.add(dto);

                        for (int j = 0; j < medicalRecords.size(); j++){
                            if(
                                medicalRecords.get(j).getFirstName().equals(persons.get(i).getFirstName())
                                &&
                                medicalRecords.get(j).getLastName().equals(persons.get(i).getLastName())
                            ){

                                int age = DateUtils.calculateAge(medicalRecords.get(j).getBirthdate());
                                if(age <= 18){
                                    children++;
                                }else{
                                    adults++;
                                }
                                break;
                            }
                        }
                    }

                }



            }
        }

        FirestationCoverageDTO result = new FirestationCoverageDTO();
        result.setPersons(personsDTO);
        result.setAdults(adults);
        result.setChildren(children);
        return result;

    }
}

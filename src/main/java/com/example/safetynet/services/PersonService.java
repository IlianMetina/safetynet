package com.example.safetynet.services;

import com.example.safetynet.dto.ChildAlertDTO;
import com.example.safetynet.models.MedicalRecord;
import com.example.safetynet.models.Person;
import com.example.safetynet.repositories.MedicalRecordRepository;
import com.example.safetynet.dto.PersonInfoDTO;
import com.example.safetynet.repositories.PersonRepository;
import com.example.safetynet.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final MedicalRecordRepository medicalRepo;

    public PersonService(PersonRepository personRepository, MedicalRecordRepository medicalRepo){
        this.personRepository = personRepository;
        this.medicalRepo = medicalRepo;
    }

    public ArrayList<Person> getPersons(){
            return personRepository.findAll();
    }

    public void addPerson(Person person) {
            personRepository.save(person);
    }

    public void updatePerson(Person person){
        personRepository.update(person);
    }


    public void deletePerson(String firstName, String lastName){
        personRepository.delete(firstName, lastName);
    }

    public ArrayList<String> getEmailsByCity(String city){
        return personRepository.getEmailsByCity(city);
    }

    public ArrayList<ChildAlertDTO> getChildrenByAddress(String address){
        ArrayList<Person> persons = personRepository.findAll();
        ArrayList<MedicalRecord> medicalRecords = medicalRepo.findAll();
        ArrayList<ChildAlertDTO> childrenInfos = new ArrayList<>();
        ArrayList<Person> residents = new ArrayList<>();

        for (int i = 0; i < persons.size(); i++){
            if(persons.get(i).getAddress().equals(address)){
                residents.add(persons.get(i));
            }
        }

        for (int i = 0; i < residents.size(); i++){
            for (int j = 0; j < medicalRecords.size(); j++){
                if(
                    medicalRecords.get(j).getFirstName().equals(residents.get(i).getFirstName())
                    &&
                    medicalRecords.get(j).getLastName().equals(residents.get(i).getLastName())
                ){
                    int age = DateUtils.calculateAge(medicalRecords.get(j).getBirthdate());
                    if(age <= 18){
                        ChildAlertDTO child = new ChildAlertDTO();
                        child.setLastName(residents.get(i).getLastName());
                        child.setFirstName(residents.get(i).getFirstName());
                        child.setAge(age);
                        child.setResidents(residents);
                        childrenInfos.add(child);
                    }
                    break;
                }
            }
        }

        return childrenInfos;
    }

    public ArrayList<PersonInfoDTO> findPersonsInfosByLastAndFirstName(String lastName, String firstName){
        ArrayList<PersonInfoDTO> personsInfos = new ArrayList<>();
        ArrayList<MedicalRecord> medicalRecords = medicalRepo.findAll();
        ArrayList<Person> persons = personRepository.findAll();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        for(int i = 0; i < persons.size(); i++){
            if(persons.get(i).getLastName().equals(lastName) && persons.get(i).getFirstName().equals(firstName)){

                PersonInfoDTO dto = new PersonInfoDTO();
                dto.setLastName(persons.get(i).getLastName());
                dto.setAddress(persons.get(i).getAddress());
                dto.setEmail(persons.get(i).getEmail());

                for (int j = 0; j < medicalRecords.size(); j++){
                    if(
                        medicalRecords.get(j).getFirstName().equals(persons.get(i).getFirstName())
                        &&
                        medicalRecords.get(j).getLastName().equals(persons.get(i).getLastName())
                    ){
                        dto.setMedications(medicalRecords.get(j).getMedications());
                        dto.setAllergies(medicalRecords.get(j).getAllergies());

                        LocalDate birthDate = LocalDate.parse(medicalRecords.get(j).getBirthdate(), formatter);
                        Integer age = Period.between(birthDate, LocalDate.now()).getYears();
                        dto.setAge(age);
                        break;
                    }
                }

                personsInfos.add(dto);
            }
        }

        return personsInfos;
    }
}
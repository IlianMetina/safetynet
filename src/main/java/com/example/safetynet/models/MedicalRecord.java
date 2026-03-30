package com.example.safetynet.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecord {

    private String firstName;
    private String lastName;
    private String birthdate;
    private ArrayList<String> medications;
    private ArrayList<String> allergies;

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthdate(){
        return this.birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public ArrayList<String> getMedications(){
        return this.medications;
    }

    public ArrayList<String> getAllergies(){
        return this.allergies;
    }
}

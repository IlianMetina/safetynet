package com.example.safetynet.dto;

import java.util.ArrayList;

public class PersonInfoDTO {

    private String lastName;
    private String address;
    private Integer age;
    private String email;
    private ArrayList<String> medications;
    private ArrayList<String> allergies;

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getAddress(){
        return this.address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public Integer getAge(){
        return this.age;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public ArrayList<String> getMedications(){
        return this.medications;
    }

    public void setMedications(ArrayList<String> medications){
        this.medications = medications;
    }

    public ArrayList<String> getAllergies(){
        return this.allergies;
    }

    public void setAllergies(ArrayList<String> allergies){
        this.allergies = allergies;
    }
}

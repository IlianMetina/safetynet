package com.example.safetynet.dto;

import java.util.ArrayList;

public class FirePersonAddressDTO {

    private String lastName;
    private String phone;
    private int age;
    private ArrayList<String> medications;
    private ArrayList<String> allergies;

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getPhone(){
        return this.phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
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

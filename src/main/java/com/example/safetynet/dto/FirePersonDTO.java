package com.example.safetynet.dto;

import java.util.ArrayList;

public class FirePersonDTO {

    private String lastName;
    private String phone;
    private int age;
    private ArrayList<String> allergies;
    private ArrayList<String> medications;

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

    public ArrayList<String> getAllergies(){
        return this.allergies;
    }

    public void setAllergies(ArrayList<String> allergies){
        this.allergies = allergies;
    }

    public ArrayList<String> getMedications(){
        return this.medications;
    }

    public void setMedications(ArrayList<String> medications){
        this.medications = medications;
    }

}

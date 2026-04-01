package com.example.safetynet.dto;

import java.util.ArrayList;

public class FloodPersonDTO {

    private String address;
    private String lastName;
    public String phone;
    public int age;
    public ArrayList<String> medications;
    public ArrayList<String> allergies;

    public String getAddress(){
        return this.address;
    }

    public void setAddress(String address){
        this.address = address;
    }

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

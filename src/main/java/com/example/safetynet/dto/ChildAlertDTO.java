package com.example.safetynet.dto;

import com.example.safetynet.models.Person;

import java.util.ArrayList;

public class ChildAlertDTO {

    private String firstName;
    private String lastName;
    private int age;
    private ArrayList<Person> residents;

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public ArrayList<Person> getResidents(){
        return this.residents;
    }

    public void setResidents(ArrayList<Person> residents){
        this.residents = residents;
    }



}

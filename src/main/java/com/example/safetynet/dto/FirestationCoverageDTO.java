package com.example.safetynet.dto;

import java.util.ArrayList;

public class FirestationCoverageDTO {

    private ArrayList<FirestationPersonDTO> persons;
    private int adults;
    private int children;

    public ArrayList<FirestationPersonDTO> getPersons(){
        return this.persons;
    }

    public void setPersons(ArrayList<FirestationPersonDTO> persons){
        this.persons = persons;
    }

    public int getAdults(){
        return this.adults;
    }

    public void setAdults(int adults){
        this.adults = adults;
    }

    public int getChildren(){
        return this.children;
    }

    public void setChildren(int children){
        this.children = children;
    }
}

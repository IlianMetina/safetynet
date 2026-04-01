package com.example.safetynet.dto;

import java.util.ArrayList;

public class FloodDTO {

    private String address;
    private ArrayList<FloodPersonDTO> persons;

    public String getAddress(){
        return this.address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public ArrayList<FloodPersonDTO> getFloodPersons(){
        return this.persons;
    }

    public void setFloodPersons(ArrayList<FloodPersonDTO> persons){
        this.persons = persons;
    }
}

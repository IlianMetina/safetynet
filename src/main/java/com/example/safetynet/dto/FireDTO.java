package com.example.safetynet.dto;

import java.util.ArrayList;

public class FireDTO {

    private ArrayList<FirePersonAddressDTO> persons;
    private String stationNumber;

    public ArrayList<FirePersonAddressDTO> getPersons(){
        return this.persons;
    }

    public void setPersons(ArrayList<FirePersonAddressDTO> persons){
        this.persons = persons;
    }

    public String getStationNumber(){
        return this.stationNumber;
    }

    public void setStationNumber(String stationNumber){
        this.stationNumber = stationNumber;
    }

}

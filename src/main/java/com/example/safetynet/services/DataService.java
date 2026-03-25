package com.example.safetynet.services;

import com.example.safetynet.models.Data;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class DataService {

    private Data data;

    public void loadData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream stream = getClass().getResourceAsStream("/data.json");
        data = mapper.readValue(stream, Data.class);
    }

    public Data getData(){
        return data;
    }

}
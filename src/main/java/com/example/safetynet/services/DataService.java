package com.example.safetynet.services;

import com.example.safetynet.models.Data;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

@Service
public class DataService {

    private Data data;

    public Data getData() throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        InputStream stream = getClass().getResourceAsStream("/data.json");
        data = mapper.readValue(stream, Data.class);
        System.out.println("==========" + data + "=========");
        return data;
    }
}
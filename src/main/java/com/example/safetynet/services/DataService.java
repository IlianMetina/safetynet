package com.example.safetynet.services;

import com.example.safetynet.models.Data;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class DataService {

    private Data data;

    ObjectMapper mapper = new ObjectMapper();
    InputStream stream = getClass().getResourceAsStream("/data.json");

}

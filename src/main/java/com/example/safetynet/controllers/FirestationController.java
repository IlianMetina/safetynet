package com.example.safetynet.controllers;

import com.example.safetynet.dto.FireDTO;
import com.example.safetynet.dto.FirestationCoverageDTO;
import com.example.safetynet.dto.FloodPersonDTO;
import com.example.safetynet.models.Firestation;
import com.example.safetynet.repositories.FirestationRepository;
import com.example.safetynet.services.FirestationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class FirestationController {

    private final FirestationService firestationService;
    private final FirestationRepository firestationRepository;

    public FirestationController(FirestationService firestationService, FirestationRepository firestationRepository){
        this.firestationService = firestationService;
        this.firestationRepository = firestationRepository;
    }

    /* ============ CRUD ============ */

    @GetMapping("firestation/get")
    public ArrayList<Firestation> findAllFirestations(){
        return this.firestationService.getFirestations();
    }

    @PostMapping("/firestation/add")
    public void addFirestation(@RequestBody Firestation firestation){
        firestationService.addFirestation(firestation);
    }


    @PutMapping("firestation/update")
    public void updateFirestation(@RequestBody Firestation firestation){
        firestationService.updateFirestation(firestation);
    }

    @DeleteMapping("firestation/remove")
    public void deleteFirestation(@RequestParam String address){
        firestationService.deleteFirestation(address);
    }
    /* ============ CRUD ============ */


    /* ============ ENDPOINTS ============ */

    @GetMapping("/firestation/getPhonesByCaserns")
    public ArrayList<String> getPhonesByCaserns(@RequestParam String station){
        return this.firestationService.getPhonesByCaserns(station);
    }

    @GetMapping("/flood/stations")
    public ArrayList<FloodPersonDTO> getFloodByStations(@RequestParam ArrayList<String> stations){
        return firestationService.getFloodByStations(stations);
    }

    @GetMapping("firestation")
    public FirestationCoverageDTO getPersonsByStationNumber(@RequestParam String stationNumber){
        return this.firestationService.getPersonsByStation(stationNumber);
    }

    @GetMapping("fire")
    public FireDTO getResidentsByAddress(@RequestParam String address){
        return firestationService.getResidentsByAddress(address);
    }

    /* ============ ENDPOINTS ============ */

}

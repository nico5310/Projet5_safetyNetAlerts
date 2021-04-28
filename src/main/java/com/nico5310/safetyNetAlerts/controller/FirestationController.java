package com.nico5310.safetyNetAlerts.controller;

import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.service.FirestationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Bean class for Spring - Communicate with Firestations Class
public class FirestationController {

    @Autowired
    private FirestationServiceInterface firestationServiceInterface;

    @GetMapping ("/firestation")
    public List<Firestation> findFirestationAll(){
        List<Firestation> findFirestation = firestationServiceInterface.findFirestationAll();
        return findFirestation;
    }

    @PostMapping("firestation")
    public List<Firestation> addFirestation(@RequestBody Firestation firestation) {
        List<Firestation> newFire = firestationServiceInterface.saveFirestationList(firestation);
        return  newFire;
    }

    @PutMapping("/firestation")
    public Firestation updateFirestation(@RequestBody Firestation firestation) {
        Firestation updateFire = firestationServiceInterface.updateFirestationList(firestation);
        return updateFire;
    }

    @DeleteMapping("/firestation/{address}")
    public List<Firestation> deleteFirestation(@PathVariable String address) {
        return firestationServiceInterface.deleteFirestationList(address);
    }


}

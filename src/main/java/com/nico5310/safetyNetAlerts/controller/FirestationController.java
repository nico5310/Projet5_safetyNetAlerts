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
    public List<Firestation> findFirestationList(){
        List<Firestation> findFirestation = firestationServiceInterface.findFirestationList();
        return findFirestation;
    }

    @PostMapping("firestation")
    public List<Firestation> addFirestation(Firestation firestation) {
        List<Firestation> newFire = firestationServiceInterface.findFirestationList();
        return  newFire;
    }

    @PutMapping("/firestation")
    public Firestation updateFirestation(Firestation firestation) {
        Firestation updateFire = firestationServiceInterface.updateFirestationList(firestation);
        return updateFire;
    }

    @DeleteMapping("/firestation")
    public boolean deleteFirestation(String address) {
        boolean deleteFire = firestationServiceInterface.deleteFirestationList(address);
        return deleteFire;
    }


}

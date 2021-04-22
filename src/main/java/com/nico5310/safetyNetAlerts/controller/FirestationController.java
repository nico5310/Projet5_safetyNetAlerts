package com.nico5310.safetyNetAlerts.controller;


import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.service.FirestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Bean class for Spring - Communicate with Firestations Class
public class FirestationController {

    @Autowired
    private FirestationService firestationService;

    @GetMapping("/firestations")
    public Iterable<Firestation> getFirestations(){
        return firestationService.getFirestations();
    }


}

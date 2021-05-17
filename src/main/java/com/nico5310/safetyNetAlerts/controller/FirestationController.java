package com.nico5310.safetyNetAlerts.controller;

import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.service.FirestationServiceInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
public class FirestationController {

    @Autowired
    private FirestationServiceInterface firestationServiceInterface;

    @GetMapping("/firestations")
    public List<Firestation> findFirestationAll() {

        List<Firestation> findFirestation = firestationServiceInterface.findFirestationAll();
        if (findFirestation != null) {
            log.info("findFirestation GET request SUCCESS");
        } else {
            log.error("findFirestation GET request FAILED");
        }
        return findFirestation;
    }

    @PostMapping("/firestation")
    public List<Firestation> addFirestation(@RequestBody Firestation firestation) {

        List<Firestation> newFire = firestationServiceInterface.saveFirestationList(firestation);
        if (newFire != null) {
            log.info("addFirestation POST request SUCCESS");
        } else {
            log.error("addFirestation POST request FAILED");
        }
        return newFire;
    }

    @PutMapping("/firestation")
    public Firestation updateFirestation(@RequestBody Firestation firestation) {

        Firestation updateFire = firestationServiceInterface.updateFirestationList(firestation);
        if (updateFire != null) {
            log.info("updateFirestation PUT request SUCCESS");
        } else {
            log.error("updateFirestation PUT request FAILED");
        }
        return updateFire;
    }

    @DeleteMapping("/firestation/{address}")
    public void deleteFirestation(@PathVariable String address) {

        if (firestationServiceInterface.deleteFirestationList(address)) {
            log.info("deleteFirestation DELETE request SUCCESS");
        } else {
            log.error("deleteFirestation DELETE request FAILED");
        }
    }


}

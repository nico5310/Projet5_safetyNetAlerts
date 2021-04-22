package com.nico5310.safetyNetAlerts.controller;

import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.service.MedicalrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Bean class for Spring - Communicate with Medicalrecords Class
public class MedicalrecordController {

    @Autowired
    private MedicalrecordService medicalrecordService;

    @GetMapping("/medicalrecords")
    public Iterable<Medicalrecord> getMedicalrecords() {
        return medicalrecordService.getMedicalrecords();
    }

}

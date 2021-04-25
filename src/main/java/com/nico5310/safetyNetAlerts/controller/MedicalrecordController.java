package com.nico5310.safetyNetAlerts.controller;

import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.service.MedicalrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Bean class for Spring - Communicate with Medicalrecords Class
public class MedicalrecordController {

    @Autowired
    private MedicalrecordService medicalrecordService;

    @GetMapping("/medicalRecords")
    public List<Medicalrecord> findMedicalrecordAll(){
        List<Medicalrecord> findMedicalrecordAll = medicalrecordService.findMedicalrecordAll();
        return findMedicalrecordAll;
    }



}

package com.nico5310.safetyNetAlerts.controller;

import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.service.MedicalrecordServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Bean class for Spring - Communicate with Medicalrecords Class
public class MedicalrecordController {

    @Autowired
    MedicalrecordServiceInterface medicalrecordServiceInterface;

    @GetMapping("/medicalRecord")
    public List<Medicalrecord> findMedicalrecordList() {
        List<Medicalrecord> findMedicalrecord = medicalrecordServiceInterface.findMedicalrecordList();
        return findMedicalrecord;
    }

    @PostMapping("/medicalRecord")
    public List<Medicalrecord> addMedicalrecord(Medicalrecord medicalrecord) {
        List<Medicalrecord> newMedical = medicalrecordServiceInterface.saveMedicalrecordList(medicalrecord);
        return newMedical;
    }

    @PutMapping("/medicalRecord")
    public Medicalrecord updateMedicalrecord(Medicalrecord medicalrecord) {
        Medicalrecord updateMedical = medicalrecordServiceInterface.updateMedicalrecordList(medicalrecord);
        return updateMedical;
    }

    @DeleteMapping("medicalRecord")
    public boolean deleteMedicalrecord(String firstName, String lastName) {
        boolean deleteMedical = medicalrecordServiceInterface.deleteMedicalrecordList(firstName, lastName);
        return deleteMedical;
    }
}

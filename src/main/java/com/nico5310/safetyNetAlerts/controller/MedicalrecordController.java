package com.nico5310.safetyNetAlerts.controller;

import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.service.MedicalrecordServiceInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
public class MedicalrecordController {

    @Autowired
    MedicalrecordServiceInterface medicalrecordServiceInterface;

    @GetMapping("/medicalRecord")
    public List<Medicalrecord> findMedicalrecordAll() {

        List<Medicalrecord> findMedicalrecord = medicalrecordServiceInterface.findMedicalrecordAll();
        if (findMedicalrecord != null) {
            log.info("findMedicalrecordAll GET request SUCCESS");
        } else {
            log.error("findMedicalRecordAll request GET is FAILED");
        }
        return findMedicalrecord;
    }

    @PostMapping("/medicalRecord")
    public List<Medicalrecord> addMedicalrecord(@RequestBody Medicalrecord medicalrecord) {

        List<Medicalrecord> newMedical = medicalrecordServiceInterface.saveMedicalrecordList(medicalrecord);
        if (newMedical != null) {
            log.info("addMedicalrecord POST request SUCCESS");
        } else {
            log.error("addMedicalrecord POST request FAILED");
        }
        return newMedical;
    }

    @PutMapping("/medicalRecord")
    public Medicalrecord updateMedicalrecord(@RequestBody Medicalrecord medicalrecord) {

        Medicalrecord updateMedical = medicalrecordServiceInterface.updateMedicalrecordList(medicalrecord);
        if (updateMedical != null) {
            log.info("updateMedicalrecord PUT request SUCCESS");
        } else {
            log.error("updateMedicalrecord PUT request FAILED");
        }
        return updateMedical;
    }

    @DeleteMapping("/medicalRecord")
    public void deleteMedicalrecord(@RequestParam String firstNameAndLastName) {

        if (medicalrecordServiceInterface.deleteMedicalrecordList(firstNameAndLastName)) {
            log.info("deleteMedicalrecord DELETE request SUCCESS");
        } else {
            log.error("deleteMedicalrecord DELETE request FAILED");
        }
    }

}

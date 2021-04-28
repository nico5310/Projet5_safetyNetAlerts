package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Medicalrecord;

import java.util.List;

public interface MedicalrecordServiceInterface {

    List<Medicalrecord> findMedicalrecordAll();
    List<Medicalrecord> saveMedicalrecordList(Medicalrecord medicalrecord);
    Medicalrecord updateMedicalrecordList(Medicalrecord medicalrecord);
    List<Medicalrecord> deleteMedicalrecordList(String firstNameAndLastName);
}

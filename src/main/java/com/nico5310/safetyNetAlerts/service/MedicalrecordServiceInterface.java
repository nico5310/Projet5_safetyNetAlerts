package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Medicalrecord;

import java.util.List;

public interface MedicalrecordServiceInterface {

    List<Medicalrecord> findMedicalrecordList();
    List<Medicalrecord> saveMedicalrecordList(Medicalrecord medicalrecord);
    Medicalrecord updateMedicalrecordList(Medicalrecord medicalrecord);
    boolean deleteMedicalrecordList(String firstName, String lastName);
}

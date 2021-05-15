package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Medicalrecord;

import java.util.List;

public interface MedicalrecordServiceInterface {

    List<Medicalrecord> findMedicalrecordAll();

    List<Medicalrecord> saveMedicalrecordList(Medicalrecord medicalrecord);

    Medicalrecord updateMedicalrecordList(String firstNameAndLastName, Medicalrecord medicalrecord);

    boolean deleteMedicalrecordList(String firstNameAndLastName);

    // Urls Endpoint

    Medicalrecord findByFirstName(String firstName);

    Medicalrecord findByFirstNameAndLastName(String firstName, String lastName);
}

package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Medicalrecord;

import java.text.ParseException;
import java.util.List;

public interface MedicalrecordServiceInterface {

    List<Medicalrecord> findMedicalrecordAll();

    List<Medicalrecord> saveMedicalrecordList(Medicalrecord medicalrecord);

    Medicalrecord updateMedicalrecordList(String firstNameAndLastName, Medicalrecord medicalrecord) throws ParseException;

    void deleteMedicalrecordList(String firstNameAndLastName);

    // Urls Endpoint

    Medicalrecord findByFirstName(String firstName);


    Medicalrecord findByFirstNameAndLastName(String firstName, String lastName);
}

package com.nico5310.safetyNetAlerts.repository;

import com.nico5310.safetyNetAlerts.model.Medicalrecord;

import java.text.ParseException;
import java.util.List;

public interface MedicalrecordRepositoryInterface {

    List<Medicalrecord> findMedicalrecordAll();


    List<Medicalrecord> saveMedicalrecordList(Medicalrecord medicalrecord);

    Medicalrecord updateMedicalrecordList(String firstNameAndLastName, Medicalrecord medicalrecord) throws ParseException;

    void deleteMedicalrecordList(String firstNameAndLastName);

    //URLS ENDPOINTS
    Medicalrecord  findByFirstName(String firstName);

    Medicalrecord findByFirstNameAndLastName(String firstName, String lastName);
}

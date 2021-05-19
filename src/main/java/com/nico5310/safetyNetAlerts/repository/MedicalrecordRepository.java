package com.nico5310.safetyNetAlerts.repository;

import com.nico5310.safetyNetAlerts.model.Database;
import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.List;

@Log4j2
@Repository
public class MedicalrecordRepository implements MedicalrecordRepositoryInterface {

    @Autowired
    Database database;

    @Autowired
    public MedicalrecordRepository(Database database) {this.database = database;}

    public Database getDatabase() {

        return database;
    }

    @Override
    public List<Medicalrecord> findMedicalrecordAll() {
        return database.getMedicalrecords();
    }

    @Override
    public List<Medicalrecord> saveMedicalrecordList(Medicalrecord medicalrecord) {

        List<Medicalrecord> saveMedical = database.getMedicalrecords();
        saveMedical.add(medicalrecord);
       return saveMedical;
    }

    @Override
    public Medicalrecord updateMedicalrecordList(String firstNameAndLastName, Medicalrecord medicalrecord) throws ParseException {

        for (Medicalrecord updateMedical : database.getMedicalrecords()) {
            if (updateMedical.getFirstNameAndLastName().equals(firstNameAndLastName)) {
                updateMedical.setBirthdate(medicalrecord.getBirthdate());
                updateMedical.setMedications(medicalrecord.getMedications());
                updateMedical.setAllergies(medicalrecord.getAllergies());
                return updateMedical;
            }
        }
        return null;
    }

    @Override
    public void deleteMedicalrecordList(String firstNameAndLastName) {
        database.getMedicalrecords().removeIf(medicalrecord -> medicalrecord.getFirstNameAndLastName().equals(firstNameAndLastName));

    }

    //URLS ENDPOINTS
    @Override
    public  Medicalrecord  findByFirstName(String firstName) {

        for (Medicalrecord medicalRecord : database.getMedicalrecords()) {
            if (medicalRecord.getFirstName().equals(firstName)) {
                log.info("findByFirstName SUCCESS :" + firstName);
                return medicalRecord;
            }
        }
        return null;
    }

    @Override
    public Medicalrecord findByFirstNameAndLastName(String firstName, String lastName) {

        for (Medicalrecord medicalRecord : database.getMedicalrecords()) {
            if (medicalRecord.getFirstName().equals(firstName) && (medicalRecord.getLastName().equals(lastName))) {
                log.info("findByFirstNameAndLastName SUCCESS :" + (firstName + lastName));
                return medicalRecord;
            }
        }
        return null;
    }
}

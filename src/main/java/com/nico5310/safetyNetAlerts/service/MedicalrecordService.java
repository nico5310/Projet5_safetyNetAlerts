package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.repository.MedicalrecordRepositoryInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class MedicalrecordService implements MedicalrecordServiceInterface {

    @Autowired
    MedicalrecordRepositoryInterface medicalrecordRepositoryInterface;

    @Override
    public List<Medicalrecord> findMedicalrecordAll() {

        try {
            log.info("findMedicalrecordAll SUCCESS :");
            return medicalrecordRepositoryInterface.getMedicalrecordAll();
        } catch (Exception exception) {
            log.error("Error retrieving the Medicalrecord list :" + exception.getMessage());
        }
        return null;
    }

    @Override
    public List<Medicalrecord> saveMedicalrecordList(Medicalrecord medicalrecord) {

        try {
            List<Medicalrecord> saveMedical = medicalrecordRepositoryInterface.getMedicalrecordAll();
            for (Medicalrecord saveMedic : saveMedical) {
                if (saveMedic.getFirstNameAndLastName().equals(medicalrecord.getFirstNameAndLastName())) {
                    log.error("ERROR Cannot create Medicalrecord List, he already exits :" + medicalrecord);
                    return null;
                }
            }
            saveMedical.add(medicalrecord);
            log.info("saveMedicalrecordList SUCCESS" + medicalrecord);
            return saveMedical;
        } catch (Exception exception) {
            log.error("Error saving the Medicalrecord to list :" + exception.getMessage());
        }
        return null;
    }

    @Override
    public Medicalrecord updateMedicalrecordList(String firstNameAndLastName, Medicalrecord medicalrecord) {

        if (medicalrecord != null) {
            List<Medicalrecord> updateMedical;
            try {

                updateMedical = medicalrecordRepositoryInterface.getMedicalrecordAll();
            } catch (Exception exception) {
                log.error("Error updating the Medicalrecord to list :");
                return null;
            }
            for (Medicalrecord update : updateMedical) {
                if (update.getFirstNameAndLastName().equals(firstNameAndLastName)) {
                    update.setBirthdate(medicalrecord.getBirthdate());
                    update.setMedications(medicalrecord.getMedications());
                    update.setAllergies(medicalrecord.getAllergies());
                    log.info("updateMedicalrecordList SUCCESS :" + medicalrecord);
                    return update;
                }
            }
        }
        return null;
    }

    @Override
    public boolean deleteMedicalrecordList(String firstNameAndLastName) {

        try {
            List<Medicalrecord> deleteMedical = medicalrecordRepositoryInterface.getMedicalrecordAll();
            return deleteMedical.removeIf(medicalrecord -> medicalrecord.getFirstNameAndLastName()
                                                                        .equals(firstNameAndLastName));

        } catch (Exception exception) {
            log.error("Error for deleting the Medicalrecord :");
        }
        log.info("deleteMedicalrecordList SUCCESS :" + firstNameAndLastName);
        return false;
    }

    //Urls Endpoints
    @Override
    public Medicalrecord findByFirstName(String firstName) {

        try {
            for (Medicalrecord medicalRecord : medicalrecordRepositoryInterface.getMedicalrecordAll()) {
                if (medicalRecord.getFirstName().equals(firstName)) {
                    log.info("findByFirstName SUCCESS :" + firstName);
                    return medicalRecord;
                }
            }
        } catch (Exception exception) {
            log.error("findByFirstName ERROR :" + exception.getMessage());
        }
        return null;
    }

    @Override
    public Medicalrecord findByFirstNameAndLastName(String firstName, String lastName) {

        try {
            for (Medicalrecord medicalRecord : medicalrecordRepositoryInterface.getMedicalrecordAll()) {
                if (medicalRecord.getFirstName().equals(firstName) && (medicalRecord.getLastName().equals(lastName))) {
                    log.info("findByFirstNameAndLastName SUCCESS :" + (firstName + lastName));
                    return medicalRecord;
                }
            }
        } catch (Exception exception) {
            log.error("findByFirstNameAndLastName ERROR :" + exception.getMessage());
        }
        return null;
    }

}



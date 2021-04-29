package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.repository.MedicalrecordRepositoryInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MedicalrecordService implements MedicalrecordServiceInterface {

    @Autowired
    MedicalrecordRepositoryInterface medicalrecordRepositoryInterface;

    @Override
    public List<Medicalrecord> findMedicalrecordAll() {

        try {
            return medicalrecordRepositoryInterface.getMedicalrecordAll();
        }catch (Exception exception) {
            log.error("Error retrieving the Medicalrecord list" + exception.getMessage());
        }
        return null; // TODO: modify return
    }

    @Override
    public List<Medicalrecord> saveMedicalrecordList(Medicalrecord medicalrecord) {

        try {
            List<Medicalrecord> saveMedical = medicalrecordRepositoryInterface.getMedicalrecordAll();
            for (Medicalrecord saveMedic : saveMedical) {
                if (saveMedic.getFirstNameAndLastName().equals(medicalrecord.getFirstNameAndLastName())) {
                    return null; //TODO: modify return
                }
            }
            saveMedical.add(medicalrecord);
            return saveMedical;
        }catch (Exception exception) {
            log.error("Error saving the Medicalrecord to list" + exception.getMessage());
        }
        return  null; //TODO: modify return
    }

    @Override
    public Medicalrecord updateMedicalrecordList(Medicalrecord medicalrecord) {

        if (medicalrecord!= null) {
            List<Medicalrecord> updateMedical;
            try {
                updateMedical = medicalrecordRepositoryInterface.getMedicalrecordAll();
            }catch (Exception exception) {
                log.error("Error updating the Medicalrecord to list");
                return null;
            }
            for (Medicalrecord update : updateMedical) {
                if (update.getFirstNameAndLastName().equals(medicalrecord.getFirstNameAndLastName())) {
                    update.setBirthdate(medicalrecord.getBirthdate());
                    update.setMedications(medicalrecord.getMedications());
                    update.setAllergies(medicalrecord.getAllergies());
                    return update;
                }
            }
        } return null; //TODO: modify return
    }

    @Override
    public List<Medicalrecord> deleteMedicalrecordList(String firstNameAndLastName) {

        try {
            List<Medicalrecord> deleteMedical = medicalrecordRepositoryInterface.getMedicalrecordAll();
            deleteMedical.removeIf(medicalrecord -> medicalrecord.getFirstNameAndLastName().equals(firstNameAndLastName));
            return deleteMedical;
        }catch (Exception exception) {
            log.error("Error for deleting the Medicalrecord");
        }
        return null; //TODO: modify return
    }

}

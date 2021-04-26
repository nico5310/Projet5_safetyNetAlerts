package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.repository.MedicalrecordRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalrecordService implements MedicalrecordServiceInterface {

    @Autowired
    MedicalrecordRepositoryInterface medicalrecordRepositoryInterface;

    @Override
    public List<Medicalrecord> findMedicalrecordList() {
        return  medicalrecordRepositoryInterface.getMedicalrecordList();
    }

    @Override
    public List<Medicalrecord> saveMedicalrecordList(Medicalrecord medicalrecord) {
        List<Medicalrecord> saveMedical = medicalrecordRepositoryInterface.getMedicalrecordList();
        saveMedical.add(medicalrecord);
        return saveMedical;
    }

    @Override
    public Medicalrecord updateMedicalrecordList(Medicalrecord medicalrecord) {
        List<Medicalrecord> updateMedical = medicalrecordRepositoryInterface.getMedicalrecordList();
        for (Medicalrecord update : updateMedical) {
            if (update.getFirstNameAndLastName().equals(medicalrecord.getFirstNameAndLastName())) {
                update.setBirthdate(medicalrecord.getBirthdate());
                update.setMedications(medicalrecord.getMedications());
                update.setAllergies(medicalrecord.getAllergies());
                return update;
            }
        } return null;
    }

    @Override
    public boolean deleteMedicalrecordList(String firstName, String lastName) {
        List<Medicalrecord> deleteMedical = medicalrecordRepositoryInterface.getMedicalrecordList();
        return deleteMedical.removeIf(medicalrecord -> medicalrecord.getFirstNameAndLastName().equals(medicalrecord.getFirstName()+medicalrecord.getLastName()));
    }

}

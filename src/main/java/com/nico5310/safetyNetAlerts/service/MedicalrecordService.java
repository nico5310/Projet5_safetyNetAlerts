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
    public List<Medicalrecord> findMedicalrecordAll() {
        return  medicalrecordRepositoryInterface.getMedicalrecordAll();
    }

    @Override
    public List<Medicalrecord> saveMedicalrecordList(Medicalrecord medicalrecord) {
        List<Medicalrecord> saveMedical = medicalrecordRepositoryInterface.getMedicalrecordAll();
        saveMedical.add(medicalrecord);
        return saveMedical;
    }

    @Override
    public Medicalrecord updateMedicalrecordList(Medicalrecord medicalrecord) {
        List<Medicalrecord> updateMedical = medicalrecordRepositoryInterface.getMedicalrecordAll();
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
    public List<Medicalrecord> deleteMedicalrecordList(String firstNameAndLastName) {
        List<Medicalrecord> deleteMedical = medicalrecordRepositoryInterface.getMedicalrecordAll();
        deleteMedical.removeIf(medicalrecord -> medicalrecord.getFirstNameAndLastName().equals(firstNameAndLastName));
        return  deleteMedical;
    }

}

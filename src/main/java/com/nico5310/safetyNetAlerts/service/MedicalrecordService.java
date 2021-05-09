package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.dto.MedicalRecordDto;
import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.repository.MedicalrecordRepositoryInterface;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
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
    public boolean deleteMedicalrecordList(String firstNameAndLastName) {

        try {
            List<Medicalrecord> deleteMedical = medicalrecordRepositoryInterface.getMedicalrecordAll();
            return deleteMedical.removeIf(medicalrecord -> medicalrecord.getFirstNameAndLastName().equals(firstNameAndLastName));

        } catch (Exception exception) {
            log.error("Error for deleting the Medicalrecord");
        }
        return false;
    }

    //Endpoints
    @Override
    public  Medicalrecord findById(String firstNameAndLastName) {

        for (Medicalrecord medicalrecord : medicalrecordRepositoryInterface.getMedicalrecordAll()) {
            if (medicalrecord.getFirstNameAndLastName().equals(firstNameAndLastName)) {
                return medicalrecord;
            }
        }
        return  null;
    }

    @Override
    public Medicalrecord findByFirstName(String firstName) {

            for (Medicalrecord medicalRecord : medicalrecordRepositoryInterface.getMedicalrecordAll()) {
            if (medicalRecord.getFirstName().equals(firstName)) {
                return medicalRecord;
            }
        }
        return null;
    }

    @Override
    public List<Medicalrecord> findByLastName(String lastName) {

        List<Medicalrecord> listMedicalRecords = new ArrayList<>();
        for (Medicalrecord medicalRecord : medicalrecordRepositoryInterface.getMedicalrecordAll()) {
            if (medicalRecord.getLastName().equals(lastName)) {
                listMedicalRecords.add(medicalRecord);
            }
        }
        return listMedicalRecords;
    }

    // Dto conversion

    private Medicalrecord fromDtoToEntity(MedicalRecordDto medicalRecordDto) {
        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setFirstName(medicalRecordDto.getFirstName());
        medicalrecord.setLastName(medicalRecordDto.getLastName());
        medicalrecord.setAge(medicalRecordDto.getAge());
        medicalrecord.setMedications(medicalRecordDto.getMedications());
        medicalrecord.setAllergies(medicalRecordDto.getAllergies());
        medicalrecord.setAge(medicalRecordDto.getAge());

        return medicalrecord;
    }

    private MedicalRecordDto fromEntityToDto(Medicalrecord medicalrecord) {
        MedicalRecordDto medicalrecordDto = new MedicalRecordDto();
        medicalrecordDto.setFirstName(medicalrecord.getFirstName());
        medicalrecordDto.setLastName(medicalrecord.getLastName());
        medicalrecordDto.setAge(medicalrecord.getAge());
        medicalrecordDto.setMedications(medicalrecord.getMedications());
        medicalrecordDto.setAllergies(medicalrecord.getAllergies());
        medicalrecordDto.setAge(medicalrecord.getAge());

        return medicalrecordDto;
    }

}

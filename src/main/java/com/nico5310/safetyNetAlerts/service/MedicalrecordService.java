package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.repository.MedicalrecordRepositoryInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Log4j2
@Service
public class MedicalrecordService implements MedicalrecordServiceInterface {

    @Autowired
    MedicalrecordRepositoryInterface medicalrecordRepositoryInterface;

    @Autowired
    public MedicalrecordService(MedicalrecordRepositoryInterface medicalrecordRepositoryInterface) {

        this.medicalrecordRepositoryInterface = medicalrecordRepositoryInterface;
    }

    @Override
    public List<Medicalrecord> findMedicalrecordAll() {

        log.info("findMedicalrecordAll SUCCESS :");
        return medicalrecordRepositoryInterface.findMedicalrecordAll();

    }

    @Override
    public List<Medicalrecord> saveMedicalrecordList(Medicalrecord medicalrecord) {

        log.info("saveMedicalrecordList SUCCESS" + medicalrecord);
        return medicalrecordRepositoryInterface.saveMedicalrecordList(medicalrecord);

    }

    @Override
    public Medicalrecord updateMedicalrecordList(String firstNameAndLastName, Medicalrecord medicalrecord) throws ParseException {

        log.info("updateMedicalrecordList SUCCESS :" + medicalrecord);
        return medicalrecordRepositoryInterface.updateMedicalrecordList(firstNameAndLastName, medicalrecord);
    }


    @Override
    public void deleteMedicalrecordList(String firstNameAndLastName) {

        List<Medicalrecord> deleteMedical = medicalrecordRepositoryInterface.findMedicalrecordAll();
        deleteMedical.removeIf(medicalrecord -> medicalrecord.getFirstNameAndLastName().equals(firstNameAndLastName));

    }

    //Urls Endpoints
    @Override
    public Medicalrecord findByFirstName(String firstName) {

        log.info("findByLastName SUCCESS :" + firstName);
        return medicalrecordRepositoryInterface.findByFirstName(firstName);

    }

    @Override
    public Medicalrecord findByFirstNameAndLastName(String firstName, String lastName) {

        log.info("findByFirstNameAndLastName SUCCESS :" + (firstName + lastName));
        return medicalrecordRepositoryInterface.findByFirstNameAndLastName(firstName, lastName);

    }

}



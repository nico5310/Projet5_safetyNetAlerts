package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.repository.MedicalrecordRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class MedicalrecordService implements MedicalrecordServiceInterface {

    @Autowired
    private final MedicalrecordRepository medicalrecordRepository;

    @Override
    public List<Medicalrecord> findMedicalrecordAll() {
        return  medicalrecordRepository.getMedicalrecordAll();
    }
}

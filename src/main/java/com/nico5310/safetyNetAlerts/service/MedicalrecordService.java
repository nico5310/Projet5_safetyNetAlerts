package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.repository.MedicalrecordRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // Bean class for Spring - Communicate with MedicalrecordsRepository interface
@Data // Lombok annotation Getters and Setters.
public class MedicalrecordService {

    @Autowired
    private final MedicalrecordRepository medicalrecordRepository;


}

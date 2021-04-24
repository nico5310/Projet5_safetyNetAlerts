package com.nico5310.safetyNetAlerts.repository;

import com.nico5310.safetyNetAlerts.model.Medicalrecord;

import java.util.List;

public interface MedicalrecordRepositoryInterface {
    List<Medicalrecord> getMedicalrecordList();
}

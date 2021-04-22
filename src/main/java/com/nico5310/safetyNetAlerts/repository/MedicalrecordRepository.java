package com.nico5310.safetyNetAlerts.repository;

import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // Class Bean for Spring - communicate with Medicalrecords class.
public interface MedicalrecordRepository extends CrudRepository<Medicalrecord, Long> {

}

package com.nico5310.safetyNetAlerts.repository;

import com.nico5310.safetyNetAlerts.model.Database;
import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Data
public class MedicalrecordRepository implements MedicalrecordRepositoryInterface{

    @Autowired
    private Database database;

    @Override
    public  List<Medicalrecord> getMedicalrecordAll () {
        return database.getMedicalrecords();
    }

}

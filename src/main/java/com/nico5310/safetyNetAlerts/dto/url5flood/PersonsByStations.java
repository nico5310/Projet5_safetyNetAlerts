package com.nico5310.safetyNetAlerts.dto.url5flood;

import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.model.Person;
import lombok.Data;

import java.util.List;

@Data
public class PersonsByStations {

    private List<Person> listPersons;
    private List<Medicalrecord> listMedicalrecords;
    private List<Long> listAges;

    public PersonsByStations(List<Person> listPersons, List<Medicalrecord> listMedicalrecords, List<Long> listAges) {

        this.listPersons        = listPersons;
        this.listMedicalrecords = listMedicalrecords;
        this.listAges           = listAges;
    }

    @Override
    public String toString() {
        return "Flood [" + getListPersons() + ", " + getListMedicalrecords() + ", " + getListAges() + "]";
    }

}

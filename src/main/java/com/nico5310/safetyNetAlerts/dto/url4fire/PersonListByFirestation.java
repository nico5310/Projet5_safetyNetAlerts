package com.nico5310.safetyNetAlerts.dto.url4fire;

import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.model.Person;
import lombok.Data;

import java.util.List;

@Data
public class PersonListByFirestation {

   List<Person> listPersons;
   List<Medicalrecord> listMedicalrecords;
   List<Long> listAges;
   Firestation firestation;

    public PersonListByFirestation(List<Person> listPersons, List<Medicalrecord> listMedicalrecords, List<Long> listAges, Firestation firestation) {

        this.listPersons        = listPersons;
        this.listMedicalrecords = listMedicalrecords;
        this.listAges           = listAges;
        this.firestation       = firestation;
    }

    @Override
    public String toString() {
        return "Fire [" + getListPersons() + ", " + getListMedicalrecords() + ", " + getListAges() + ", " + getFirestation() + "]";
    }
}

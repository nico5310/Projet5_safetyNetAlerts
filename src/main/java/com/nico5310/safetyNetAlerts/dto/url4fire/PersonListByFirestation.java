package com.nico5310.safetyNetAlerts.dto.url4fire;

import com.nico5310.safetyNetAlerts.dto.urlData.PersonFireFloodListDto;
import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.model.Person;
import lombok.Data;

import java.util.List;

@Data
public class PersonListByFirestation {

   List<Person> personList;
   List<Medicalrecord> medicalrecordList;
   List<Long> ageList;
   Firestation firestation;

    public PersonListByFirestation(List<Person> personList, List<Medicalrecord> medicalrecordList, List<Long> ageList, Firestation firestation) {

        this.personList        = personList;
        this.medicalrecordList = medicalrecordList;
        this.ageList           = ageList;
        this.firestation       = firestation;
    }

    @Override
    public String toString() {
        return "Fire [" + getPersonList() + ", " + getMedicalrecordList() + ", " + getAgeList() + ", " + getFirestation() + "]";
    }
}

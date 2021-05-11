package com.nico5310.safetyNetAlerts.dto.url6personInfo;

import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.model.Person;
import lombok.Data;

import java.util.List;

@Data
public class PersonInfoDto {

    private List<Person> listPersons;
    private List<Medicalrecord> listMedicalrecords;
    private List<Integer> listAges;

    /**
     * Constructor
     * @param listPersons
     * @param listMedicalrecords
     * @param listAges
     */
    public PersonInfoDto(List<Person> listPersons, List<Medicalrecord> listMedicalrecords, List<Integer> listAges) {

        this.listPersons          = listPersons;
        this.listMedicalrecords = listMedicalrecords;
        this.listAges           = listAges;
    }

    @Override
    public String toString() {
        return "PersonInfo [" + getListPersons() + "]";
    }

}

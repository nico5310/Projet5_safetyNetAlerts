package com.nico5310.safetyNetAlerts.dto.url2childAlert;

import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.model.Person;
import lombok.Data;

import java.util.List;

@Data
public class ChildByAddressDto {

    private List<Person> listPersons;
    private List<Medicalrecord>  listMedicalrecords;
    private List<Long> listAges;

    private static long children;

    /**
     * constructor ChildByAddressDto
     *
     */
    public ChildByAddressDto(List<Person> listPersons, List<Medicalrecord> listMedicalrecords, List<Long> listAges, long children) {
        super();
        this.listPersons = listPersons;
        this.listMedicalrecords = listMedicalrecords;
        this.listAges = listAges;
        this.children = children;
    }

    /**
     * constructor children
     * @return children
     */
    public static long getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "ChildByAddress [" + getListPersons() + ", " + getListMedicalrecords() + ", " + getListAges() + "]";
    }

}

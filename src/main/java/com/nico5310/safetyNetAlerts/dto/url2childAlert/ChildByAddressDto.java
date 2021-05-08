package com.nico5310.safetyNetAlerts.dto.url2childAlert;

import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.model.Person;
import lombok.Data;

import java.util.List;

@Data
public class ChildByAddressDto {

    private List<Person>         listPers;
    private List<Medicalrecord>  listMedicalrecord;
    private List<Long> age;

    private static long children;

    /**
     * constructor ChildByAddressDto
     * @param listPers
     * @param listMedicalrecord
     * @param age
     * @param children
     */
    public ChildByAddressDto(List<Person> listPers, List<Medicalrecord> listMedicalrecord, List<Long> age, long children) {
        super();
        this.listPers = listPers;
        this.listMedicalrecord = listMedicalrecord;
        this.age = age;
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
        return "ChildByAddress [" + getListPers() + ", " + getListMedicalrecord() + ", " + getAge() + "]";
    }

}

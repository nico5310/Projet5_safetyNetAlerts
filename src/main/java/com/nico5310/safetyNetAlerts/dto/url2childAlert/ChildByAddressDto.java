package com.nico5310.safetyNetAlerts.dto.url2childAlert;

import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.model.Person;
import lombok.Data;

import java.util.List;

@Data
public class ChildByAddressDto {

    private String firstName;
    private String lastName;
    private int age;

    public ChildByAddressDto(String firstName, String lastName, int age) {

        this.firstName = firstName;
        this.lastName  = lastName;
        this.age       = age;
    }

    public ChildByAddressDto(List<Person> listPersons, List<Medicalrecord> listMedicalrecords, List<Integer> listAgeCalculate, long children) {}

    @Override
    public String toString(){
        return "PersonWithAge [firstName=" + getFirstName() + ", lastName=" + getLastName() + ", age= " +getAge() + "]" ;
    }

}

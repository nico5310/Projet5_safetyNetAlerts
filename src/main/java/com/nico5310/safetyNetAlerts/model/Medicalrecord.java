package com.nico5310.safetyNetAlerts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class Medicalrecord {

    private String       firstName;
    private String       lastName;
    private String       birthdate;
    private List<String> medications;
    private List<String> allergies;
    @JsonIgnore
    private int          age;
    @JsonIgnore
    private String       firstNameAndLastName;

    public String getFirstNameAndLastName() {

        return firstName + lastName;
    }

    public Medicalrecord() {

    }

    public Medicalrecord(String firstName, String lastName, String birthdate, List<String> medications, List<String> allergies, int age, String firstNameAndLastName) {

        this.firstName            = firstName;
        this.lastName             = lastName;
        this.birthdate            = birthdate;
        this.medications          = medications;
        this.allergies            = allergies;
        this.age                  = age;
        this.firstNameAndLastName = firstNameAndLastName;
    }

    @Override
    public String toString() {

        return getFirstName() + ", " + getLastName() + ", " + getBirthdate() + ", " + getMedications() + ", " + getAllergies() + "\n";
    }

}

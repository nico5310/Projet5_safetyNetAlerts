package com.nico5310.safetyNetAlerts.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class Medicalrecord {

    private String firstName;
    private String lastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private String birthdate;
    private List<String> medications;
    private List<String> allergies;
    @JsonIgnore
    private int age;
    @JsonIgnore
    private String firstNameAndLastName;

    /**
     * Constructor ID
     * @return
     */
    public String getFirstNameAndLastName() {
        return firstName + lastName;
    }

    /**
     * Constructor Medicalrecord
     */
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

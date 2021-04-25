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
    private String firstNameAndLastName;

    public String getFirstNameAndLastName() {
        return firstName + lastName;
    }

    @Override
    public String toString() {
        return getFirstName() + ", " + getLastName() + ", " + getBirthdate() + ", " + getMedications() + ", " + getAllergies() + "\n";
    }

}

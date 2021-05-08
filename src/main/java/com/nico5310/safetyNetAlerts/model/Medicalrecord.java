package com.nico5310.safetyNetAlerts.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
@Component
public class Medicalrecord {

    private String       firstName;
    private String       lastName;
    private LocalDate       birthdate;
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
            super();
    }

    @Override
    public String toString() {
        return getFirstName() + ", " + getLastName() + ", " + getBirthdate() + ", " + getMedications() + ", " + getAllergies() + "\n";
    }

}

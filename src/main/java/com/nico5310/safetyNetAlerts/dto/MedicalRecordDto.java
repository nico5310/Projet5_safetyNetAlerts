package com.nico5310.safetyNetAlerts.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import lombok.Data;

import java.util.List;

@Data
public class MedicalRecordDto {

    private String       firstName;
    private String       lastName;
    private String       birthdate;
    private List<String> medications;
    private List<String> allergies;

    @JsonIgnore
    private int age;

    @JsonIgnore
    private String firstNameAndLastName;

    /**
     * Constructor Id
     * @return
     */
    public String getFirstNameAndLastName() {
        return firstName + lastName;
    }

    /**
     * Constructor MedicalRecordDto
     */
    public MedicalRecordDto() {

    }

    public MedicalRecordDto (Medicalrecord medicalrecord) {
        this.firstName = medicalrecord.getFirstName();
        this.lastName = medicalrecord.getLastName();
        this.birthdate = medicalrecord.getBirthdate();
        this.medications = medicalrecord.getMedications();
        this.allergies = medicalrecord.getAllergies();
        this.age = medicalrecord.getAge();
        this.firstNameAndLastName = medicalrecord.getFirstNameAndLastName();


    }
}

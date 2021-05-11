package com.nico5310.safetyNetAlerts.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import lombok.Data;

import java.util.List;

@Data
public class MedicalRecordDto {

    private String firstName;
    private String lastName;
    private List<String> medications;
    private List<String> allergies;
    private int age;
    @JsonIgnore
    private String firstNameAndLastName;

    /**
     * Constructor Id
     * @return FirstNameAndLastName ID
     */
    public String getFirstNameAndLastName() {
        return firstName + lastName;
    }

    /**
     * Constructor MedicalRecordDto
     */
    public MedicalRecordDto() {
        super();
    }

    public MedicalRecordDto (Medicalrecord medicalRecord) {

        this.firstName = medicalRecord.getFirstName();
        this.lastName = medicalRecord.getLastName();
        this.medications = medicalRecord.getMedications();
        this.allergies = medicalRecord.getAllergies();
        this.age = medicalRecord.getAge();
        this.firstNameAndLastName = medicalRecord.getFirstNameAndLastName();
    }

}
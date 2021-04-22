package com.nico5310.safetyNetAlerts.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "medicalrecords")
public class Medicalrecord {

    @Id
    @GeneratedValue
    private Long id;

    private String       firstName;
    private String       lastName;

    private String       birthdate;

    @ElementCollection
    private List<String> medications;
    @ElementCollection
    private List<String> allergies;

    @Override

    public String toString() {
        return getFirstName() + ", " + getLastName() + ", " + getBirthdate() + ", " + getMedications() + ", " + getAllergies() + "\n";
    }

}

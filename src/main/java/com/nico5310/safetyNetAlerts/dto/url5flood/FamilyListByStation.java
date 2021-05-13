package com.nico5310.safetyNetAlerts.dto.url5flood;

import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.model.Person;
import lombok.Data;

import java.util.List;

@Data
public class FamilyListByStation {

    private String lastName;
    private String phone;
    private int age;
    private List<String> medications;
    private List<String> allergies;

    public FamilyListByStation(String lastName, String phone, int age, List<String> medications, List<String> allergies) {

        this.lastName    = lastName;
        this.phone       = phone;
        this.age         = age;
        this.medications = medications;
        this.allergies   = allergies;
    }
    @Override
    public String toString() {
        return "Flood [" + getLastName() + ", " + getPhone() + ", " + getAge() + ", " + getMedications() + ", " + getAllergies() + "]";
    }

}

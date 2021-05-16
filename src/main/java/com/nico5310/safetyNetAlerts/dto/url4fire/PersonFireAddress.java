package com.nico5310.safetyNetAlerts.dto.url4fire;

import lombok.Data;

import java.util.List;

@Data
public class PersonFireAddress {

    private String lastName;
    private String phone;
    private int age;
    private List<String> medications;
    private List<String> allergies;



    public PersonFireAddress(String lastName, String phone, int age, List<String> medications, List<String> allergies) {

        this.lastName    = lastName;
        this.phone       = phone;
        this.age         = age;
        this.medications = medications;
        this.allergies   = allergies;
    }




    @Override
    public String toString() {
        return "PersonFireAddress [lastName=" + getLastName() + ", phone=" + getPhone()+ ", age=" + getAge() + ", medications="
               + getMedications() + ", allergies =" + getAllergies() + "]";
    }


}

package com.nico5310.safetyNetAlerts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Person {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String zip;
    private String phone;
    private String email;

    @JsonIgnore
    private String firstNameAndLastName;
    public String getFirstNameAndLastName() {
        return firstName + lastName;
    }

    @JsonIgnore
    private int age;

    @JsonIgnore
    private Medicalrecord medicalrecord;

    @JsonIgnore
    private Firestation firestation;

    @Override
    public String toString(){
        return getFirstName() + ", " + getLastName() + ", " + getAddress() + ", " + getCity() + ", " + getZip() + ", " + getPhone() + ", " + getEmail() + "\n";
    }
}

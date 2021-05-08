package com.nico5310.safetyNetAlerts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
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
    private int age;
    @JsonIgnore
    private Medicalrecord medicalrecord;
    @JsonIgnore
    private Firestation firestation;

    @JsonIgnore
    private String firstNameAndLastName;
    /**
     * Constructor Id
     * @return ID firstName + lastName
     */
    public String getFirstNameAndLastName() {
        return firstName + lastName;
    }

    /**
     * Constructor for Person
     */
    public Person() {
        super();
    }


    @Override
    public String toString(){
        return getFirstName() + ", " + getLastName() + ", " + getAddress() + ", " + getCity() + ", " + getZip() + ", " + getPhone() + ", " + getEmail() + "\n";
    }
}

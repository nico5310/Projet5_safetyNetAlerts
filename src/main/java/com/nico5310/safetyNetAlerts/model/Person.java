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

    public  Person(String firstName, String lastName, String address, String city, String zip, String phone, String email, int age) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString(){
        return getFirstName() + ", " + getLastName() + ", " + getAddress() + ", " + getCity() + ", " + getZip() + ", " + getPhone() + ", " + getEmail() + "\n";
    }
}

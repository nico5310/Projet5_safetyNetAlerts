package com.nico5310.safetyNetAlerts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


public class Medicalrecord {

    private String       firstName;
    private String       lastName;
    private String       birthdate;
    private List<String> medications;
    private List<String> allergies;
    @JsonIgnore
    private int          age;
    @JsonIgnore
    private String       firstNameAndLastName;

    public Medicalrecord(String s, String lastName, String birthdate, List<String> medications, List<String> allergies) {}

    public Medicalrecord() {

    }

    public Medicalrecord(String firstName, String lastName, String birthdate, List<String> medications, List<String> allergies, int age, String firstNameAndLastName) {

        this.firstName            = firstName;
        this.lastName             = lastName;
        this.birthdate            = birthdate;
        this.medications          = medications;
        this.allergies            = allergies;
        this.age                  = age;
        this.firstNameAndLastName = firstNameAndLastName;
    }

    public String getFirstNameAndLastName() {

        return firstName + lastName;
    }

    public void setFirstNameAndLastName(String firstNameAndLastName) {

        this.firstNameAndLastName = firstNameAndLastName;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getBirthdate() {

        return birthdate;
    }

    public void setBirthdate(String birthdate) {

        this.birthdate = birthdate;
    }

    public List<String> getMedications() {

        return medications;
    }

    public void setMedications(List<String> medications) {

        this.medications = medications;
    }

    public List<String> getAllergies() {

        return allergies;
    }

    public void setAllergies(List<String> allergies) {

        this.allergies = allergies;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }

    @Override
    public String toString() {

        return getFirstName() + ", " + getLastName() + ", " + getBirthdate() + ", " + getMedications() + ", " + getAllergies() + "\n";
    }

}

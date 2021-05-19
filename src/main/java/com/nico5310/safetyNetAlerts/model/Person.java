package com.nico5310.safetyNetAlerts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Person {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String zip;
    private String phone;
    private String email;
    @JsonIgnore
    int age;
    @JsonIgnore
    private Medicalrecord medicalrecord;
    @JsonIgnore
    private Firestation   firestation;
    @JsonIgnore
    private String        firstNameAndLastName;


    public String getFirstNameAndLastName() {
        return firstName + lastName;
    }

    public Person() {
    }

    public Person(String firstName, String lastName, String address, String city, String zip, String phone, String email, int age, Medicalrecord medicalrecord, Firestation firestation, String firstNameAndLastName) {

        this.firstName            = firstName;
        this.lastName             = lastName;
        this.address              = address;
        this.city                 = city;
        this.zip                  = zip;
        this.phone                = phone;
        this.email                = email;
        this.age                  = age;
        this.medicalrecord        = medicalrecord;
        this.firestation          = firestation;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Medicalrecord getMedicalrecord() {
        return medicalrecord;
    }

    public void setMedicalrecord(Medicalrecord medicalrecord) {
        this.medicalrecord = medicalrecord;
    }

    public Firestation getFirestation() {
        return firestation;
    }

    public void setFirestation(Firestation firestation) {
        this.firestation = firestation;
    }

    public void setFirstNameAndLastName(String firstNameAndLastName) {
        this.firstNameAndLastName = firstNameAndLastName;
    }

    @Override
    public String toString() {

        return getFirstName() + ", " + getLastName() + ", " + getAddress() + ", " + getCity() + ", " + getZip() + ", " + getPhone() + ", " + getEmail() + "\n";
    }
}

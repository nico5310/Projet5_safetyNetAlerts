package com.nico5310.safetyNetAlerts.dto;

import lombok.Data;

@Data
public class PersonDto {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String zip;
    private String phone;
    private String email;
    private long age;
    private MedicalRecordDto medicalRecordDto;
    private FirestationDto firestationDto;

    private String firstNameAndLastName;

    public PersonDto(String firstName, String lastName, String address, String city, String zip, String phone, String email, int age, MedicalRecordDto medicalRecordDto, FirestationDto firestationDto, String firstNameAndLastName) {

        this.firstName            = firstName;
        this.lastName             = lastName;
        this.address              = address;
        this.city                 = city;
        this.zip                  = zip;
        this.phone                = phone;
        this.email                = email;
        this.age                  = age;
        this.medicalRecordDto     = medicalRecordDto;
        this.firestationDto       = firestationDto;
        this.firstNameAndLastName = firstNameAndLastName;
    }

    public PersonDto() {

    }
}
package com.nico5310.safetyNetAlerts.dto.url5flood;

import lombok.Data;

@Data
public class PersonsByStationDto {

    private String firstName;
    private String lastName;
    private String phone;
    private int              age;
    private MedicalRecordByStationDto medicalRecordByStationDto;

    public PersonsByStationDto(String firstName, String lastName, String phone, int age, MedicalRecordByStationDto medicalRecordByStationDto) {

        this.firstName                 = firstName;
        this.lastName                  = lastName;
        this.phone                     = phone;
        this.age                       = age;
        this.medicalRecordByStationDto = medicalRecordByStationDto;
    }
}

package com.nico5310.safetyNetAlerts.dto.url6personInfo;


import lombok.Data;

import java.util.List;

@Data
public class PersonInfoDto {

    private String lastName;
    private String address;
    private int age;
    private String email;
    private List<String> medications;
    private List<String> allergies;

      public PersonInfoDto(String lastName, String address, int age, String email, List<String> medications, List<String> allergies) {

        this.lastName    = lastName;
        this.address     = address;
        this.age         = age;
        this.email       = email;
        this.medications = medications;
        this.allergies   = allergies;
    }

}

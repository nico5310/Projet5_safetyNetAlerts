package com.nico5310.safetyNetAlerts.dto;

import com.nico5310.safetyNetAlerts.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Data
@Component
public class PersonDto {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String zip;
    private String phone;
    private String email;
    private int age;
    private MedicalRecordDto medicalRecordDto;
    private FirestationDto firestationDto;

    private String firstNameAndLastName;

    public PersonDto() {
        super();
    }

    public  PersonDto ( Person person) {

        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.address = person.getAddress();
        this.city = person.getCity();
        this.zip = person.getZip();
        this.phone = person.getPhone();
        this.email = person.getEmail();
        this.age = person.getAge();
        this.medicalRecordDto = getMedicalRecordDto();
        this.firestationDto = getFirestationDto();
        this.firstNameAndLastName = person.getFirstNameAndLastName();
    }


}


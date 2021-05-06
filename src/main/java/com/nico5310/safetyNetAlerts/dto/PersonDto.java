package com.nico5310.safetyNetAlerts.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.model.Person;
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

    @JsonIgnore
    private String firstNameAndLastName;
        /**
     * Constructeur for Id
     * @return
     */
    public String getFirstNameAndLastName() {
        return firstName + lastName;
    }

    @JsonIgnore
    private int age;

    @JsonIgnore
    private Medicalrecord medicalrecord;

    @JsonIgnore
    private Firestation firestation;


    /**
     * Constructor for PersonDto
     */
    public PersonDto() {
        super();
    }

    public PersonDto(Person person) {
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.address = person.getAddress();
        this.city = person.getAddress();
        this.zip = person.getZip();
        this.phone = person.getPhone();
        this.email = person.getEmail();
        this.firstNameAndLastName = person.getFirstNameAndLastName();
        this.age = person.getAge();
        this.medicalrecord = person.getMedicalrecord();
        this.firestation = person.getFirestation();
    }




  }


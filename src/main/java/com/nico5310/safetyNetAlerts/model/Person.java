package com.nico5310.safetyNetAlerts.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;

    private String address;
    private String city;
    private String zip;
    private String phone;
    private String email;

    @Override
    public String toString(){
        return getFirstName() + ", " + getLastName() + ", " + getAddress() + ", " + getCity() + ", " + getZip() + ", " + getPhone() + ", " + getEmail() + "\n";
    }
}

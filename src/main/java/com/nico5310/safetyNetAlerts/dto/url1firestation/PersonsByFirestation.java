package com.nico5310.safetyNetAlerts.dto.url1firestation;

import lombok.Data;



@Data
public class PersonsByFirestation  {

    private String firstName;
    private String lastName;
    private String address;
    private String phone;


    public PersonsByFirestation(String firstName, String lastName, String address, String phone) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.address   = address;
        this.phone     = phone;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {

        return lastName;
    }


    public String getAddress() {

        return address;
    }


    public String getPhone() {

        return phone;
    }


}

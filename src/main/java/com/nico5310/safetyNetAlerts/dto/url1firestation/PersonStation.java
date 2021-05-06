package com.nico5310.safetyNetAlerts.dto.url1firestation;

import lombok.Data;

@Data
public class PersonStation {

    private String firstName;
    private String lastName;
    private String address;
    private String phone;

    public PersonStation(String firstName, String lastName, String address, String city, String zip, String phone) {}

    @Override
    public String toString() {
        return "PersonStation [" + getFirstName() + ", " + getLastName() + ", " + getAddress() + ", " + getPhone() + "]";
    }


}

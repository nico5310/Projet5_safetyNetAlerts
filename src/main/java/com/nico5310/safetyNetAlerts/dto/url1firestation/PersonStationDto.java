package com.nico5310.safetyNetAlerts.dto.url1firestation;

import lombok.Data;

@Data
public class PersonStationDto {

    private String firstName;
    private String lastName;
    private String address;
    private String phone;

    public PersonStationDto(String firstName, String lastName, String address, String phone) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "PersonStation [" + firstName + ", " + lastName + ", " + address + ", " + phone + "]";
    }


}

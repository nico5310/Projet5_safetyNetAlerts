package com.nico5310.safetyNetAlerts.dto.url2childAlert;

import lombok.Data;

@Data
public class AgeOfPerson {

    private String firstName;
    private String lastName;
    private int age;

    @Override
    public String toString() {
        return "AgeOfPerson [" + getFirstName() + ", " + getLastName() + ", " + getAge() + "]";
    }

}

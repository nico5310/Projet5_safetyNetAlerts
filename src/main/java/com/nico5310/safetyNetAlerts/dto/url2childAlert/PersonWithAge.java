package com.nico5310.safetyNetAlerts.dto.url2childAlert;

import lombok.Data;

@Data
public class PersonWithAge {

    private String firstName;
    private String lastName;
    private int age;

    public PersonWithAge(String firstName, String lastName, int age) {

        this.firstName = firstName;
        this.lastName  = lastName;
        this.age       = age;
    }

    @Override
    public String toString(){
        return "PersonWithAge [firstName=" + getFirstName() + ", lastName=" + getLastName() + ", age= " +getAge() + "]" ;
    }
}

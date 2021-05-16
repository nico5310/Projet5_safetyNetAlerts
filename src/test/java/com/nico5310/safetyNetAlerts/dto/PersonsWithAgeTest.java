package com.nico5310.safetyNetAlerts.dto;

import com.nico5310.safetyNetAlerts.dto.url2childAlert.PersonsWithAge;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonsWithAgeTest {

    private PersonsWithAge personsWithAge;

    @Test
    @DisplayName("Test set and get to firstname parameter")
    public void setAndGetFirstnameTest() {
        //GIVEN
        String firstName = "nicolas";
        int age = 0;

        //WHEN
        personsWithAge = new PersonsWithAge(firstName, null, age);

        //THEN
        assertEquals(firstName, personsWithAge.getFirstName());

    }

    @Test
    @DisplayName("Test set and get to lastName parameter")
    public void setAndGetLastNameTest() {
        //GIVEN
        String lastName = "biancucci";
        int age = 0;

        //WHEN
        personsWithAge = new PersonsWithAge(null, lastName, age);

        //THEN
        assertEquals(lastName, personsWithAge.getLastName());

    }


    @Test
    @DisplayName("Test set and get to age parameter")
    public void setAndGetLastAgeTest() {
        //GIVEN

        int age = 40;

        //WHEN
        personsWithAge = new PersonsWithAge(null, null, age);

        //THEN
        assertEquals(age, personsWithAge.getAge());

    }

}

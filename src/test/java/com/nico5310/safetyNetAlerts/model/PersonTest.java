package com.nico5310.safetyNetAlerts.model;


import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonTest {

    private Person person;

    @Test
    @DisplayName("Test set and get to firstname parameter")
    public void setAndGetFirstNameTest() {
        //GIVEN
        String firstName = "nicolas";
        int age = 0;

        //WHEN
        person = new  Person(firstName, null, null, null, null, null, null, age, null, null, null);

        //THEN
        assertEquals(firstName, person.getFirstName());
    }

    @Test
    @DisplayName("Test set and get to lastName parameter")
    public void setAndGetLastNameTest() {
        //GIVEN
        String lastName = "biancucci";
        int age = 0;

        //WHEN
        person = new  Person(null, lastName, null, null, null, null, null, age, null, null, null);

        //THEN
        assertEquals(lastName, person.getLastName());
    }

    @Test
    @DisplayName("Test set and get to address parameter")
    public void setAndGetAddressTest() {
        //GIVEN
        String address = "4 le village ";
        int age = 0;

        //WHEN
        person = new  Person(null, null, address,  null, null, null, null, age, null, null, null);

        //THEN
        assertEquals(address, person.getAddress());
    }

    @Test
    @DisplayName("Test set and get to city parameter")
    public void setAndGetCityTest() {
        //GIVEN
        String city = "thurigneux ";
        int age = 0;

        //WHEN
        person = new  Person(null, null, null,  city, null, null, null, age, null, null, null);

        //THEN
        assertEquals(city, person.getCity());
    }

    @Test
    @DisplayName("Test set and get to zip parameter")
    public void setAndGetZipTest() {
        //GIVEN
        String zip = "01390 ";
        int age = 0;

        //WHEN
        person = new  Person(null, null, null,  null, zip, null, null, age, null, null, null);

        //THEN
        assertEquals(zip, person.getZip());
    }

    @Test
    @DisplayName("Test set and get to phone parameter")
    public void setAndGetPhoneTest() {
        //GIVEN
        String phone = "0611111111 ";
        int age = 0;

        //WHEN
        person = new  Person(null, null, null,  null, null, phone, null, age, null, null, null);

        //THEN
        assertEquals(phone, person.getPhone());
    }

    @Test
    @DisplayName("Test set and get to email parameter")
    public void setAndGetEmailTest() {
        //GIVEN
        String email = "nico@gmail.com ";
        int age = 0;

        //WHEN
        person = new  Person(null, null, null,  null, null, null, email, age, null, null, null);

        //THEN
        assertEquals(email, person.getEmail());
    }

    @Test
    @DisplayName("Test set and get to age parameter")
    public void setAndGetAgeTest() {
        //GIVEN
        int age = 40;

        //WHEN
        person = new  Person(null, null, null,  null, null, null, null, age, null, null, null);

        //THEN
        assertEquals(age, person.getAge());
    }

    @Test
    @DisplayName("Test set and get to medicalrecord parameter")
    public void setAndGetMedicalrecordTest() {
        //GIVEN
        Medicalrecord medicalrecord = new Medicalrecord();
        int age                     = 0;

        //WHEN
        person = new  Person(null, null, null,  null, null, null, null, age, medicalrecord, null, null);

        //THEN
        assertEquals(medicalrecord, person.getMedicalrecord());
    }

    @Test
    @DisplayName("Test set and get to firestation parameter")
    public void setAndGetFirestationTest() {
        //GIVEN
        Firestation firestation = new Firestation();
        int age                     = 0;

        //WHEN
        person = new  Person(null, null, null,  null, null, null, null, age, null, firestation, null);

        //THEN
        assertEquals(firestation, person.getFirestation());
    }

}


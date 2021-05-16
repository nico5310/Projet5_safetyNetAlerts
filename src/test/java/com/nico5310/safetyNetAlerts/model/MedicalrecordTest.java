package com.nico5310.safetyNetAlerts.model;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MedicalrecordTest {

    private Medicalrecord medicalrecord;

    @Test
    @DisplayName("Test set and get to firstName parameter")
    public void setAndGetFirstNameTest() {
    //GIVEN
        String firstName = "nicolas";
        int age = 0;

        //WHEN
        medicalrecord =new Medicalrecord(firstName,null,null,null,null,age,null);

        //THEN
        assertEquals(firstName, medicalrecord.getFirstName());
    }

    @Test
    @DisplayName("Test set and get to lastName parameter")
    public void setAndGetlastNameTest() {
        //GIVEN
        String lastName = "biancucci";
        int age = 0;

        //WHEN
        medicalrecord =new Medicalrecord(null,lastName,null,null,null,age,null);

        //THEN
        assertEquals(lastName, medicalrecord.getLastName());
    }

    @Test
    @DisplayName("Test set and get to birthdate parameter")
    public void setAndGetBirthdateTest() {
        //GIVEN
        String birthdate = "10/07/1980";
        int age = 0;

        //WHEN
        medicalrecord =new Medicalrecord(null,null,birthdate,null,null,age,null);

        //THEN
        assertEquals(birthdate, medicalrecord.getBirthdate());
    }

    @Test
    @DisplayName("Test set and get to list medications parameter")
    public void setAndGetMedicationsTest() {
        //GIVEN
        List<String>  medications   = new ArrayList<String>();
        int age = 0;

        //WHEN
        medicalrecord =new Medicalrecord(null,null,null, medications,null,age,null);

        //THEN
        assertEquals(medications, medicalrecord.getMedications());
    }

    @Test
    @DisplayName("Test set and get to list allergies parameter")
    public void setAndGetAllergiesTest() {
        //GIVEN
        List<String>  allergies   = new ArrayList<String>();
        int age = 0;

        //WHEN
        medicalrecord =new Medicalrecord(null,null,null, null,allergies,age,null);

        //THEN
        assertEquals(allergies, medicalrecord.getAllergies());
    }

    @Test
    @DisplayName("Test set and get to age parameter")
    public void setAndGetAgeTest() {
        //GIVEN
        int age = 40;

        //WHEN
        medicalrecord =new Medicalrecord(null,null,null, null,null,age,null);

        //THEN
        assertEquals(age, medicalrecord.getAge());
    }
}



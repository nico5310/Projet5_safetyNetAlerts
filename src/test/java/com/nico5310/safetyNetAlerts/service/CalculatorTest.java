package com.nico5310.safetyNetAlerts.service;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    MedicalrecordServiceInterface medicalrecordServiceInterface;

    private Calculator calculator = new Calculator();

    @Test
    @DisplayName("Test for calculate age type person between birthdate")
    public void calculateAgeTypeSinceBirthDate() {
        //GIVEN:
        String birthdateChild    = "05/29/2018";
        String birthdateAdult = "10/07/1980";

        //WHEN
        calculator.calculateAge(birthdateChild);
        calculator.calculateAge(birthdateAdult);
        long children = calculator.getChildren();
        long adults = calculator.getAdults();


        //THEN
        assertEquals(children, 1);
        assertEquals(adults, 1);

    }

    @Test
    @DisplayName("Test for calculate age of person between birthdate")
    public void calculateAgeOfChildSinceBirthDate() {
        //GIVEN:
        String birthdateChild    = "05/10/2014";

        //WHEN
        calculator.calculateAge(birthdateChild);
        long children = calculator.getAge();

        //THEN
        assertEquals(children, 7);
    }

    @Test
    @DisplayName("Test for calculate age of person between birthdate")
    public void calculateAgeOfPersonSinceBirthDate() {
        //GIVEN:
        String birthdateAdult = "10/07/1980";

        //WHEN
        calculator.calculateAge(birthdateAdult);
        long adults = calculator.getAge();

        //THEN
        assertEquals(adults, 40);

    }
}

package com.nico5310.safetyNetAlerts.service;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

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

}

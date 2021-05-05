package com.nico5310.safetyNetAlerts.service;

import java.time.LocalDate;
import java.time.Period;

public class Calculator {

    public static int calculateAge(LocalDate birthDate) {

        int age;

        age = Period.between(birthDate, LocalDate.now()).getYears();

        return age;
    }

}

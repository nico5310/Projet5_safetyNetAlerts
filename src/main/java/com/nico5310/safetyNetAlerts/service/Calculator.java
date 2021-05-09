package com.nico5310.safetyNetAlerts.service;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class Calculator {

    private long children = 0;
    private long adults = 0;
    private       int           age              = 0;
    private final List<Integer> listAgeCalculate = new ArrayList<Integer>();

    /**
     * Constructor for calculator
     */
    public Calculator() {

    }
    public Calculator(long children, long adults, int age) {

        this.children = children;
        this.adults   = adults;
        this.age      = age;
    }


    public void calculateAge(String birthDate) {

        int age;
        age = Period.between(LocalDate.parse(birthDate), LocalDate.now()).getYears();
        listAgeCalculate.add(age);

        if (age < 18) {
            children++;
        }else {
            adults++;
        }


    }



}

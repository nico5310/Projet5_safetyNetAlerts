package com.nico5310.safetyNetAlerts.service;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Calculator {

    private long children = 0;
    private long adults = 0;
    private long age = 0;
    private final List<Long> listAgeCalculate = new ArrayList<Long>();

    /**
     * Constructor for calculator
     */
    public Calculator() {

    }

   /**
     * Constructor of children
     * @return numChildrenber children
     */
    public long getChildren() {
        return children;
    }

    /**
     * Constructor of Adults
     * @return numAdults
     */
    public long getAdults() {
        return adults;
    }

    /**
     * Constructor of age
     * @return age
     */
    public long getAge() {
        return age;
    }

    /**
     * Constructor of listAgeCalculate
     * @return listAgeCalculate
     */
    public List<Long> getListAgeCalculate() {

        return listAgeCalculate;
    }



    public void calculateAge(LocalDate birthDate) {

        long age;
        age = Period.between(birthDate, LocalDate.now()).getYears();
        listAgeCalculate.add(age);

        if (age < 18) {
            children++;
        }else {
            adults++;
        }

    }



}

package com.nico5310.safetyNetAlerts.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private       long          children         = 0;
    private       long          adults           = 0;
    private       int           age              = 0;
    private final List<Integer> listAgeCalculate = new ArrayList<Integer>();

    public long getChildren() {
        return children;
    }

    public void setChildren(long children) {
        this.children = children;
    }

    public long getAdults() {
        return adults;
    }

    public void setAdults(long adults) {
        this.adults = adults;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Integer> getListAgeCalculate() {
        return listAgeCalculate;
    }


     public void calculateAge(String birthDate) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        age = Period.between(LocalDate.parse(birthDate, dateTimeFormatter), LocalDate.now()).getYears();
        listAgeCalculate.add(age);

        if (age < 18) {
            children++;
        } else {
            adults++;
        }

    }


}




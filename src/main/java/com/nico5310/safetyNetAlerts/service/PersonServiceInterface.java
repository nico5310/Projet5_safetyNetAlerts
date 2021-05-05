package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Person;

import java.util.List;

public interface PersonServiceInterface {

    List<Person> findPersonAll();

    List<Person> savePersonList(Person person);
    Person updatePersonList(Person person);
    boolean deletePersonList(String firstNameAndLastName);

    Person findById(String firstNameAndLastName) throws Exception;
    List<Person> findByAddress(String address);
    List<Person> findEmailByCity(String city);
}

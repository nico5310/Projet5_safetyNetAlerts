package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Person;

import java.util.List;

public interface PersonServiceInterface {

    List<Person> findPersonAll();
    List<Person> savePersonList(Person person);
    Person updatePersonList(Person person);
    List<Person> deletePersonList(String firstNameAndLastName);
}

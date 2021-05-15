package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Person;

import java.util.List;

public interface PersonServiceInterface {

    List<Person> findPersonAll();

    List<Person> savePersonList(Person person);

    Person updatePersonList(String firstNameAndLastName, Person person);

    List<Person> deletePersonList(String firstNameAndLastName);

    // Urls Endpoints

    List<Person> findByAddress(String address);

    List<Person> findByLastName(String lastName);

    List<Person> findByFirstNameAndLastName(String firstName, String lastName);

    List<Person> findEmailByCity(String city);

}

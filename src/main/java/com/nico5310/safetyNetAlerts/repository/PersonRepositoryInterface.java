package com.nico5310.safetyNetAlerts.repository;

import com.nico5310.safetyNetAlerts.model.Person;

import java.util.List;

public interface PersonRepositoryInterface {


    List<Person> findPersonAll();

    List<Person> savePersonList(Person person);

    Person updatePersonList(String firstNameAndLastName, Person person);

    void deletePersonList(String firstNameAndLastName);

    List<Person> findByAddress(String address);

    List<Person> findByLastName(String lastName);

    List<Person> findByFirstNameAndLastName(String firstName, String lastName);

    List<Person> findEmailByCity(String city);
}

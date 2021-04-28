package com.nico5310.safetyNetAlerts.repository;

import com.nico5310.safetyNetAlerts.model.Person;

import java.util.List;

public interface PersonRepositoryInterface {
    List<Person> getPersonAll();
}

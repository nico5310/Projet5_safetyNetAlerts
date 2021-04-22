package com.nico5310.safetyNetAlerts.repository;

import com.nico5310.safetyNetAlerts.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // Class Bean for Spring - communicate with Persons class.
public interface PersonRepository extends CrudRepository<Person, Long> {

}

package com.nico5310.safetyNetAlerts.repository;

import com.nico5310.safetyNetAlerts.json.Database;
import com.nico5310.safetyNetAlerts.model.Person;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Data
public class PersonRepository implements PersonRepositoryInterface {

    @Autowired
    Database database;

    @Override
    public List<Person> getPersonAll() {
        return database.getPersons();
    }

}

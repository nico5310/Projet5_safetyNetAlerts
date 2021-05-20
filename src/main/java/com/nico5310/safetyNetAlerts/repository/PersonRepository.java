package com.nico5310.safetyNetAlerts.repository;

import com.nico5310.safetyNetAlerts.model.Database;
import com.nico5310.safetyNetAlerts.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class PersonRepository implements PersonRepositoryInterface {

    private List<Person> persons;
    @Autowired
    private Database database;

    public PersonRepository() {}

    @Override
    public List<Person> findPersonAll() {

        return database.getPersons();
    }

    @Override
    public List<Person> savePersonList(Person person) {

        List<Person> savePerson = database.getPersons();
        savePerson.add(person);
        return savePerson;
    }

    @Override
    public Person updatePersonList(String firstNameAndLastName, Person person) {

        List<Person> updatePerson;

        updatePerson = database.getPersons();
        for (Person update : updatePerson) {
            if (update.getFirstNameAndLastName().equals(firstNameAndLastName)) {
                update.setAddress(person.getAddress());
                update.setCity(person.getCity());
                update.setZip(person.getZip());
                update.setPhone(person.getPhone());
                update.setEmail(person.getEmail());
                return update;
            }
        }
        return null;
    }

    @Override
    public void deletePersonList(String firstNameAndLastName) {

        List<Person> deletePerson = database.getPersons();
        deletePerson.removeIf(person -> person.getFirstNameAndLastName().equals(firstNameAndLastName));

    }

    // Urls Endpoints

    @Override
    public List<Person> findByAddress(String address) {

        List<Person> listPerson = new ArrayList<Person>();
        for (Person person : database.getPersons()) {
            if (person.getAddress().equals(address)) {
                listPerson.add(person);
            }
        }
        return listPerson;
    }

    @Override
    public List<Person> findByLastName(String lastName) {

        List<Person> listPerson = new ArrayList<Person>();
        for (Person person : database.getPersons()) {
            if (person.getLastName().equals(lastName)) {
                listPerson.add(person);
            }
        }
        return listPerson;

    }


    @Override
    public List<Person> findByFirstNameAndLastName(String firstName, String lastName) {

        List<Person> listPerson = new ArrayList<Person>();
        for (Person person : database.getPersons()) {
            if (person.getFirstName().equals(firstName) && (person.getLastName().equals(lastName))) {
                listPerson.add(person);
            }
        }
        return listPerson;
    }

    @Override
    public List<Person> findEmailByCity(String city) {

        List<Person> listPerson = new ArrayList<>();
        for (Person person : database.getPersons()) {
            if (person.getCity().equals(city)) {
                listPerson.add(person);
            }
        }
        return listPerson;
    }

}

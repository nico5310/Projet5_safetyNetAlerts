package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Person;
import com.nico5310.safetyNetAlerts.repository.PersonRepositoryInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class PersonService implements PersonServiceInterface {

    @Autowired
    PersonRepositoryInterface personRepositoryInterface;


    @Override
    public List<Person> findPersonAll() {

        try {
            log.info("findPersonAll SUCCESS :");
            return personRepositoryInterface.getPersonAll();
        } catch (Exception exception) {
            log.error("findPersonAll ERROR :" + exception.getMessage());
        }
        return null;
    }

    @Override
    public List<Person> savePersonList(Person person) {

        try {
            List<Person> savePerson = personRepositoryInterface.getPersonAll();
            for (Person savePers : savePerson) {
                if (savePers.getFirstNameAndLastName().equals(person.getFirstNameAndLastName())) {
                    log.info("ERROR Cannot create Person List, he already exists :" + person);
                    return null;
                }
            }
            savePerson.add(person);
            log.info("Person saved SUCCESS :" + person);
            return savePerson;
        } catch (Exception exception) {
            log.error("savePersonList ERROR :" + exception.getMessage());
        }
        return null;
    }

    @Override
    public Person updatePersonList(Person person) {

        if (person != null) {
            List<Person> updatePerson;
            try {

                updatePerson = personRepositoryInterface.getPersonAll();
            } catch (Exception exception) {
                log.error("updatePersonList ERROR :" + exception.getMessage());
                return null;
            }
            for (Person update : updatePerson) {
                if (update.getFirstNameAndLastName().equals(person.getFirstNameAndLastName())) {
                    update.setAddress(person.getAddress());
                    update.setCity(person.getCity());
                    update.setZip(person.getZip());
                    update.setPhone(person.getPhone());
                    update.setEmail(person.getEmail());
                    log.info("updatePersonList SUCCESS :" + person);
                    return update;
                }
            }
        }
        return null;
    }

    @Override
    public boolean deletePersonList(String firstNameAndLastName) {

        try {
            List<Person> deletePerson = personRepositoryInterface.getPersonAll();
            return deletePerson.removeIf(person -> person.getFirstNameAndLastName().equals(firstNameAndLastName));

        } catch (Exception exception) {
            log.error("deletePersonList ERROR :" + exception.getMessage());
        }
        log.info("deletePersonList SUCCESS :" + firstNameAndLastName);
        return false;
    }

    // Urls Endpoints

    @Override
    public List<Person> findByAddress(String address) {

        try {
            List<Person> listPerson = new ArrayList<Person>();
            for (Person person : personRepositoryInterface.getPersonAll()) {
                if (person.getAddress().equals(address)) {
                    listPerson.add(person);
                }
            }
            log.info("findByAddress SUCCESS :" + address);
            return listPerson;
        } catch (Exception exception) {
            log.error("findByAddress ERROR :" + exception.getMessage());
        }
        return null;
    }

    @Override
    public List<Person> findByLastName(String lastName) {

        try {
            List<Person> listPerson = new ArrayList<Person>();
            for (Person person : personRepositoryInterface.getPersonAll()) {
                if (person.getLastName().equals(lastName)) {
                    listPerson.add(person);
                }
            }
            log.info("findByAddress SUCCESS :" + lastName);
            return listPerson;
        } catch (Exception exception) {
            log.error("findByAddress ERROR :" + exception.getMessage());
        }
        return null;
    }


    @Override
    public List<Person> findByFirstNameAndLastName(String firstName, String lastName) {

        try {
            List<Person> listPerson = new ArrayList<Person>();
            for (Person person : personRepositoryInterface.getPersonAll()) {
                if (person.getFirstName().equals(firstName) && (person.getLastName().equals(lastName))) {
                    listPerson.add(person);
                }
            }
            log.info("findByFirstNameAndLastName SUCCESS :" + (firstName+lastName));
            return listPerson;
        } catch (Exception exception) {
            log.error(" findByFirstNameAndLastName ERROR :" + exception.getMessage());
    }

    return null;
}

    @Override
    public List<Person> findEmailByCity(String city) {

        try {
            List<Person> listPerson = new ArrayList<>();
            for (Person person : personRepositoryInterface.getPersonAll()) {
                if (person.getCity().equals(city)) {
                    listPerson.add(person);
                }
            }
            log.info("findByEmailCity SUCCESS :" + city );
            return listPerson;
        } catch (Exception exception) {
            log.error("findByEmailCity ERROR :" + exception.getMessage());
        }
        return null;
    }

}
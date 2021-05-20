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

    public PersonService(PersonRepositoryInterface personRepositoryInterface) {

        this.personRepositoryInterface = personRepositoryInterface;
    }


    @Override
    public List<Person> findPersonAll() {

        return personRepositoryInterface.findPersonAll();
    }

    @Override
    public List<Person> savePersonList(Person person) {

        log.info("Person saved SUCCESS :" + person);
        personRepositoryInterface.savePersonList(person);
        return personRepositoryInterface.findPersonAll();
    }

    @Override
    public Person updatePersonList(String firstNameAndLastName, Person person) {

                log.info("updatePersonList SUCCESS :" + person);
                return personRepositoryInterface.updatePersonList(firstNameAndLastName, person);
    }

    @Override
    public List<Person> deletePersonList(String firstNameAndLastName) {


        log.info("deletePersonList SUCCESS :" + firstNameAndLastName);
        personRepositoryInterface.deletePersonList(firstNameAndLastName);
        return personRepositoryInterface.findPersonAll();

    }

    // Urls Endpoints

    @Override
    public List<Person> findByAddress(String address) {

        log.info("findByAddress SUCCESS :" + address);
        return personRepositoryInterface.findByAddress(address);
    }

    @Override
    public List<Person> findByLastName(String lastName) {

        log.info("findByAddress SUCCESS :" + lastName);
        return personRepositoryInterface.findByLastName(lastName);
    }


    @Override
    public List<Person> findByFirstNameAndLastName(String firstName, String lastName) {

        log.info("findByFirstNameAndLastName SUCCESS :" + (firstName + lastName));
        return personRepositoryInterface.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<Person> findEmailByCity(String city) {

        log.info("findByEmailCity SUCCESS :" + city);
        return personRepositoryInterface.findEmailByCity(city);
    }

}
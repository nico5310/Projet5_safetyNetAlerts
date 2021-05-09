package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.dto.PersonDto;
import com.nico5310.safetyNetAlerts.model.Person;
import com.nico5310.safetyNetAlerts.repository.PersonRepositoryInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PersonService implements PersonServiceInterface {

    @Autowired
    PersonRepositoryInterface personRepositoryInterface;


    @Override
    public List<Person> findPersonAll() {
        try {
            return personRepositoryInterface.getPersonAll();
        } catch (Exception exception) {
            log.error("Error retrieving the People list" + exception.getMessage());
        }
        return null; // TODO: modify return
    }

    @Override
    public List<Person> savePersonList(Person person) {

        try {
            List<Person> savePerson = personRepositoryInterface.getPersonAll();
            for (Person savePers : savePerson) {
                if (savePers.getFirstNameAndLastName().equals(person.getFirstNameAndLastName())) {
                    return null; // TODO: modify return
                }
            }
            savePerson.add(person);
            return savePerson;
        } catch (Exception exception) {
            log.error("Error saving the People to list" + exception.getMessage());
        }
        return null; // TODO: modify return
    }

    @Override
    public Person updatePersonList(Person person) {

        if (person != null) {
            List<Person> updatePerson;
            try {
                updatePerson = personRepositoryInterface.getPersonAll();
            } catch (Exception exception) {
                log.error("Error updating the People to list" + exception.getMessage());
                return null; // TODO: modify return
            }
            for (Person update : updatePerson) {
                if (update.getFirstNameAndLastName().equals(person.getFirstNameAndLastName())) {
                    update.setAddress(person.getAddress());
                    update.setCity(person.getCity());
                    update.setZip(person.getZip());
                    update.setPhone(person.getPhone());
                    update.setEmail(person.getEmail());
                    return update;
                }
            }
        }
        return null; // TODO: modify return
    }

    @Override
    public boolean deletePersonList(String firstNameAndLastName) {

        try {
            List<Person> deletePerson = personRepositoryInterface.getPersonAll();
            return deletePerson.removeIf(person -> person.getFirstNameAndLastName().equals(firstNameAndLastName));

        } catch (Exception exception) {
            log.error("Error for deleting the Person" + exception.getMessage());
        }
        return false;
    }

    // Endpoints
    @Override
    public Person findById(String firstNameAndLastName) {

        for (Person person : personRepositoryInterface.getPersonAll()) {
            if (person.getFirstNameAndLastName().equals(firstNameAndLastName)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public List<Person> findByAddress(String address) {

        List<Person> listPerson = new ArrayList<Person>();
        for (Person person : personRepositoryInterface.getPersonAll()) {
            if (person.getAddress().equals(address)) {
                listPerson.add(person);
            }
        }
        return listPerson;
    }

    @Override
    public List<Person> findByLastName(String lastName) {

        List<Person> listPerson = new ArrayList<Person>();
        for (Person person : personRepositoryInterface.getPersonAll()) {
            if (person.getLastName().equals(lastName)) {
                listPerson.add(person);
            }
        }
        return  listPerson;
    }

    @Override
    public  List<Person> findEmailByCity(String city) {

        List<Person> listPerson = new ArrayList<Person>();
        List<String> mail = new ArrayList<String>();
        for (Person person : personRepositoryInterface.getPersonAll()) {
            if (person.getCity().equals(city)) {
                listPerson.add(person);
            }
        }
        return listPerson;
    }


    // Dto conversion
//    private PersonDto fromEntityToDto(Person person) {
//
//        PersonDto personDto = new PersonDto();
//        personDto.setFirstName(person.getFirstName());
//        personDto.setLastName(person.getLastName());
//        personDto.setAddress(person.getAddress());
//        personDto.setZip(person.getZip());
//        personDto.setPhone(person.getPhone());
//        personDto.setEmail(person.getEmail());
//        personDto.setAge(person.getAge());
//
//        return personDto;
//    }
//
//    private Person fromDtoToEntity(PersonDto personDto) {
//
//        Person person = new Person();
//        person.setFirstName(personDto.getFirstName());
//        person.setLastName(personDto.getLastName());
//        person.setAddress(personDto.getAddress());
//        person.setZip(personDto.getZip());
//        person.setPhone(personDto.getPhone());
//        person.setEmail(personDto.getEmail());
//        person.setAge(personDto.getAge());
//        return person;
//    }


}
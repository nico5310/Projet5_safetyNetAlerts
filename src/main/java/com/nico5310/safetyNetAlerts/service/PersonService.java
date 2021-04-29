package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Person;
import com.nico5310.safetyNetAlerts.repository.PersonRepositoryInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
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
    public List<Person> deletePersonList(String firstNameAndLastName) {

        try {
            List<Person> deletePerson = personRepositoryInterface.getPersonAll();
            deletePerson.removeIf(person -> person.getFirstNameAndLastName().equals(firstNameAndLastName));
            return deletePerson;
        } catch (Exception exception) {
            log.error("Error for deleting the Person" + exception.getMessage());
        }
        return null; // TODO: modify return
    }

}




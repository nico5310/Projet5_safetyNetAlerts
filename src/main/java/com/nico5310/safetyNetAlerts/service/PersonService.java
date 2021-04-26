package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Person;
import com.nico5310.safetyNetAlerts.repository.PersonRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements PersonServiceInterface{

    @Autowired
    PersonRepositoryInterface personRepositoryInterface;

    @Override
    public List<Person> findPersonAll(){
           return  personRepositoryInterface.getPersonAll();
        }

    @Override
    public List<Person> savePersonList(Person person) {
        List<Person> savePerson = personRepositoryInterface.getPersonAll();
            savePerson.add(person);
            return savePerson;
        }

    @Override
    public Person updatePersonList(Person person) {
        List<Person> updatePerson = personRepositoryInterface.getPersonAll();
        for (Person update : updatePerson) {
            if (update.getFirstNameAndLastName().equals(person.getFirstNameAndLastName())) {
                update.setAddress(person.getAddress());
                update.setCity(person.getCity());
                update.setZip(person.getZip());
                update.setPhone(person.getPhone());
                update.setEmail(person.getEmail());
                return update;
            }
        } return null;
    }

    @Override
    public boolean deletePersonList(String firstName, String lastName) {
        List<Person> deletePerson = personRepositoryInterface.getPersonAll();
        return deletePerson.removeIf(person -> person.getFirstNameAndLastName().equals(person.getFirstName() + person.getLastName()));
    }

}

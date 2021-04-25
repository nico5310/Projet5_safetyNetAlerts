package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Person;
import com.nico5310.safetyNetAlerts.repository.PersonRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class PersonService implements PersonServiceInterface{

    @Autowired
    private final PersonRepository personRepository;

    @Override
    public List<Person> findPersonAll(){
        return  personRepository.getPersonAll();
    }

    @Override
    public List<Person> savePersonList(Person person) {
            List<Person> savePerson = personRepository.getPersonAll();
            savePerson.add(person);
            return savePerson;
        }

//    @Override
//    public Person addPersonList(String firstName, String lastName, String address, String city, String zip, String phone, String email) {
//        Person addPerson = personRepository.getPersonList();
//        addPerson.add(persons)
//        return addPerson;
//    }



//    public Person updatePersonList(Person person) {
//        List<Person> updatePerson = personRepository.getPersonList();
//        return updatePerson;
//    }

//    public Person deletePersonList(Person person) {
//        List<Person> deletePerson = personRepository.getPersonList();
//        return deletePerson;
//    }

}

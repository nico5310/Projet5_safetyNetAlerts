package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Person;
import com.nico5310.safetyNetAlerts.repository.PersonRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Data
public class PersonService implements PersonServiceInterface{

    @Autowired
    private final PersonRepository personRepository;

    @Override
    public List<Person> findPersonList(){
        return  personRepository.getPersonList();
    }

//    public Person addPersonList(Person person) {
//        Person addPerson = personRepository.getPersonList();
//        return addPerson;
//    }
//
//    public List<Person> savePersonList(Person person) {
//        List<Person> savePerson = personRepository.getPersonList();
//        return savePerson;
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

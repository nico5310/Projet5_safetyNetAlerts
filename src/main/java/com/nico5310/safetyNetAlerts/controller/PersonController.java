package com.nico5310.safetyNetAlerts.controller;

import com.nico5310.safetyNetAlerts.model.Person;
import com.nico5310.safetyNetAlerts.service.PersonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Bean class for Spring - Communicate with PersonsService Class
public class PersonController {

    @Autowired
    PersonServiceInterface personServiceInterface;

    @GetMapping("/person")
    public List<Person> findPersonAll() {
        return personServiceInterface.findPersonAll();
    }

    @PostMapping("/person")
    public List<Person> addPerson(Person person) {
        List<Person> newPers = personServiceInterface.savePersonList(person);
        return  newPers;
    }

    @PutMapping("/person")
    public Person updatePerson(Person person) {
        Person updatePers = personServiceInterface.updatePersonList(person);
        return updatePers;
    }

    @DeleteMapping("/person")
    public boolean deletePerson(String firstName, String lastName) {
        boolean deletePers = personServiceInterface.deletePersonList(firstName, lastName);
        return deletePers;
    }

}

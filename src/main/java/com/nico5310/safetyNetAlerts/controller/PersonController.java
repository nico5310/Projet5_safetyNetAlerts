package com.nico5310.safetyNetAlerts.controller;

import com.nico5310.safetyNetAlerts.model.Person;
import com.nico5310.safetyNetAlerts.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Bean class for Spring - Communicate with PersonsService Class
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public Iterable<Person> getPersons() {
        return personService.getPersons();
    }

}

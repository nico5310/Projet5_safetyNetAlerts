package com.nico5310.safetyNetAlerts.controller;

import com.nico5310.safetyNetAlerts.model.Person;
import com.nico5310.safetyNetAlerts.service.PersonServiceInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
public class PersonController {

    @Autowired
    PersonServiceInterface personServiceInterface;

    @GetMapping(value = "/person")
    public List<Person> findPersonAll() {

        List<Person> findPerson = personServiceInterface.findPersonAll();
        if (findPerson != null) {
            log.info("findPersonAll GET request SUCCESS");
        } else {
            log.error("findPersonAll GET request FAILED");
        }
        return findPerson;
    }

    @PostMapping(value = "/person")
    public List<Person> addPerson(@RequestBody Person person) {

        List<Person> newPers = personServiceInterface.savePersonList(person);
        if (newPers != null) {
            log.info("addPerson POST request SUCCESS");
        } else {
            log.error("addPerson POST request FAILED");
        }
        return newPers;
    }

    @PutMapping(value = "/person/{firstNameAndLastName}")
    public Person updatePerson(@RequestBody Person person, @PathVariable String firstNameAndLastName) {

        Person updatePers = personServiceInterface.updatePersonList(firstNameAndLastName, person);
        if (updatePers != null) {
            log.info("updatePerson PUT request SUCCESS");
        } else {
            log.error("updatePerson PUT request FAILED ");
        }
        return updatePers;
    }

    @DeleteMapping(value = "/person/{firstNameAndLastName}")
    public List<Person> deletePerson(@PathVariable String firstNameAndLastName) {

        log.info("deletePerson DELETE request SUCCESS");
        return personServiceInterface.deletePersonList(firstNameAndLastName);

    }

}

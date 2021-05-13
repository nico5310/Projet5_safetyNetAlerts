package com.nico5310.safetyNetAlerts.controller;

import com.nico5310.safetyNetAlerts.model.Person;
import com.nico5310.safetyNetAlerts.service.PersonServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PersonController {

    @Autowired
    PersonServiceInterface personServiceInterface;

    @GetMapping("/person")
    public List<Person> findPersonAll() {

        List<Person> findPerson = personServiceInterface.findPersonAll();
        if (findPerson != null) {
            log.info("findPersonAll GET request SUCCESS");
        } else {
            log.error("findPersonAll GET request FAILED");
        }
        return findPerson;
    }

    @PostMapping("/person")
    public List<Person> addPerson(@RequestBody Person person) {

        List<Person> newPers = personServiceInterface.savePersonList(person);
        if (newPers != null) {
            log.info("addPerson POST request SUCCESS");
        } else {
            log.error("addPerson POST request FAILED");
        }
        return newPers;
    }

    @PutMapping("/person")
    public Person updatePerson(@RequestBody Person person) {

        Person updatePers = personServiceInterface.updatePersonList(person);
        if (updatePers != null) {
            log.info("updatePerson PUT request SUCCESS");
        } else {
            log.error("updatePerson PUT request FAILED ");
        }
        return updatePers;
    }

    @DeleteMapping("/person")
    public void deletePerson(@RequestParam String firstNameAndLastName) {

        if (personServiceInterface.deletePersonList(firstNameAndLastName)) {
            log.info("deletePerson DELETE request SUCCESS");
        } else {
            log.error("deletePerson DELETE request FAILED");
        }
    }

}

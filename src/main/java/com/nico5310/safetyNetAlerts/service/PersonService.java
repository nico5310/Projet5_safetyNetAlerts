package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Person;
import com.nico5310.safetyNetAlerts.repository.PersonRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Data // Lombok annotation Getters and Setters.
@Service // Bean class for Spring - Communicate with PersonsRepository interface
public class PersonService {

    @Autowired
    private final PersonRepository personRepository;




}

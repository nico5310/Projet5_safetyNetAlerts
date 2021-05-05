package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.controller.UrlEndpointsController;
import com.nico5310.safetyNetAlerts.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlEndpointService {

    @Autowired
    static PersonServiceInterface personServiceInterface;

    public static List<Person> allEmailByCity(String city) {
                return personServiceInterface.findEmailByCity(city);
    }

}

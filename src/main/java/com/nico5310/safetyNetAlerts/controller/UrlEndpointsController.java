package com.nico5310.safetyNetAlerts.controller;

import com.nico5310.safetyNetAlerts.dto.url7communityEmail.EmailList;
import com.nico5310.safetyNetAlerts.model.Person;
import com.nico5310.safetyNetAlerts.service.UrlEndpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UrlEndpointsController {

    @Autowired
    UrlEndpointService urlEndpointService;

        @GetMapping("/communityEmail")
        public EmailList allEmailByCity (@RequestParam ("city") String city) {

            List<String> email = new ArrayList<>();
            for (Person person : UrlEndpointService.allEmailByCity(city)) {
                email.add(person.getEmail());
            }
            return new EmailList(email);
        }






}

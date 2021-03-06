package com.nico5310.safetyNetAlerts.controller;

import com.nico5310.safetyNetAlerts.dto.url1firestation.PersonsByStationDto;
import com.nico5310.safetyNetAlerts.dto.url2childAlert.ChildByAddressDto;
import com.nico5310.safetyNetAlerts.dto.url3phoneAlert.PhoneAlertListDto;
import com.nico5310.safetyNetAlerts.dto.url4fire.PersonListByAddress;
import com.nico5310.safetyNetAlerts.dto.url5flood.FamilyListByStation;
import com.nico5310.safetyNetAlerts.dto.url6personInfo.PersonInfoDto;
import com.nico5310.safetyNetAlerts.dto.url7communityEmail.EmailListDto;
import com.nico5310.safetyNetAlerts.service.UrlEndpointService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;


@RestController
@Log4j2
public class UrlEndpointsController {

    @Autowired
    UrlEndpointService urlEndpointService;

    //URL 1 firestation
    @GetMapping(value = "/firestation")
    public PersonsByStationDto allPersonsByStation(@RequestParam(value = "stationNumber") int stationNumber) throws ParseException {

        log.info("allPersonsByStation");
        return urlEndpointService.allPersonsByStation(stationNumber);
    }

    //URL 2 childAlerts
    @GetMapping(value = "/childAlert")
    public ChildByAddressDto allChildByAddress(@RequestParam(value = "address") String address) throws ParseException {

        log.info("allChildByAddress");
        return urlEndpointService.allChildByAddress(address);
    }

    // URL 3 phoneAlert
    @GetMapping(value = "/phoneAlert")
    public PhoneAlertListDto allPhoneByFirestation(@RequestParam(value = "firestation") int firestation) {

        log.info("allPhoneByFirestation");
        return urlEndpointService.allPhoneByFirestation(firestation);
    }

    // URL 4 fire
    @GetMapping(value = "/fire")
    public PersonListByAddress allPersonsByAddress(@RequestParam(value = "address") String address) throws ParseException {

        log.info("allPersonsByAddress");
        return urlEndpointService.allPersonsByAddress(address);
    }

    // URL 5 flood
    @GetMapping(value = "/flood/stations")
    public List<FamilyListByStation> allFamilyByStation(@RequestParam(value = "stations") List<Integer> stations) throws ParseException {

        log.info("allFamilyByStation");
        return urlEndpointService.allFamilyByStation(stations);
    }

    // URL 6 personinfo
    @GetMapping(value = "/personInfo")
    public List<PersonInfoDto> allPersonInfo(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName) throws ParseException {

        log.info("allPersonInfo");
        return urlEndpointService.allPersonInfo(firstName, lastName);
    }

    //URL 7 communityEmail
    @GetMapping(value = "/communityEmail")
    public EmailListDto allEmailsByCity(@RequestParam(value = "city") String city) {

        log.info("allEmailsByCity");
        return urlEndpointService.allEmailsByCity(city);
    }

}

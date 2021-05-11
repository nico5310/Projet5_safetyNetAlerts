package com.nico5310.safetyNetAlerts.controller;

import com.nico5310.safetyNetAlerts.dto.url1firestation.PersonsByStationDto;
import com.nico5310.safetyNetAlerts.dto.url2childAlert.ChildByAddressDto;
import com.nico5310.safetyNetAlerts.dto.url3phoneAlert.PhoneAlertListDto;
import com.nico5310.safetyNetAlerts.dto.url4fire.PersonListByAddress;
import com.nico5310.safetyNetAlerts.dto.url5flood.FamilyListByStation;
import com.nico5310.safetyNetAlerts.dto.url6personInfo.PersonInfoDto;
import com.nico5310.safetyNetAlerts.dto.url7communityEmail.EmailListDto;
import com.nico5310.safetyNetAlerts.model.Person;
import com.nico5310.safetyNetAlerts.service.UrlEndpointService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class UrlEndpointsController {

    @Autowired
    UrlEndpointService urlEndpointService;

    //URL 1 firestation
    @GetMapping(value = "/firestation/{stationNumber}")
    public PersonsByStationDto allPersonsByStation (@PathVariable int stationNumber) {
        return urlEndpointService.allPersonsByStation(stationNumber);
    }

    //URL 2 childAlerts
    @GetMapping(value = "/childAlert/{address}")
    public ChildByAddressDto allChildByAddress (@PathVariable String address) {
        ChildByAddressDto childByAddressDto = urlEndpointService.allChildByAddress(address);
        long children = ChildByAddressDto.getChildren();
        if (children == 0) {
            return null;
        }else {
            return  childByAddressDto;
        }
    }

    // URL 3 phoneAlert
    @GetMapping(value = "/phoneAlert/{firestationNumber}")
    public PhoneAlertListDto allPhoneByFirestation(@PathVariable int firestationNumber) {
        return  urlEndpointService.allPhoneByFirestation(firestationNumber);
    }

    // URL 4 fire
    @GetMapping(value = "/fire/{address}")
    public PersonListByAddress allPersonsByAddress(@PathVariable String address) throws ParseException {
        return urlEndpointService.allPersonsByAddress(address);
    }

    // URL 5 flood
    @GetMapping(value = "/flood/stations/{stationNumber}")
    public FamilyListByStation allFamilyByStation(@PathVariable int stationNumber) throws ParseException {
        return urlEndpointService.allFamilyByStation(stationNumber);
    }

    // URL 6 personinfo
    @GetMapping(value = "/personInfo/{firstName}{lastName}")
    public PersonInfoDto allPersonInfo(@RequestParam(value = "firstname") String firstName, @RequestParam (value = "lastName") String lastName) throws ParseException, org.json.simple.parser.ParseException {
        return  urlEndpointService.allPersonInfo(firstName, lastName);
    }

    //URL 7 communityEmail
    @GetMapping(value = "/communityEmail/{city}")
    public  EmailListDto allEmailsByCity(@PathVariable String city) {
        return urlEndpointService.allEmailsByCity(city);
    }

}

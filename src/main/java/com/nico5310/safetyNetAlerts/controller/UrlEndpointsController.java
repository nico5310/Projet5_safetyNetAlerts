package com.nico5310.safetyNetAlerts.controller;

import com.nico5310.safetyNetAlerts.dto.url1firestation.PersonsByStationDto;
import com.nico5310.safetyNetAlerts.dto.url2childAlert.ChildByAddressDto;
import com.nico5310.safetyNetAlerts.dto.url3phoneAlert.PhoneAlertListDto;
import com.nico5310.safetyNetAlerts.dto.url4fire.PersonListByAddress;
import com.nico5310.safetyNetAlerts.service.UrlEndpointService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@Slf4j
public class UrlEndpointsController {

    @Autowired
    UrlEndpointService urlEndpointService;

    //URL 1 firestation
    @GetMapping(value = "/firestation{stationNumber}")
    public PersonsByStationDto allPersonsByStation (@PathVariable int stationNumber) {
        return urlEndpointService.allPersonsByStation(stationNumber);
    }

    //URL 2 childAlerts
    @GetMapping(value = "/childAlert{address}")
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
    @GetMapping(value = "/phoneAlert{firestationNumber}")
    public PhoneAlertListDto allPhoneByFirestation(@PathVariable int firestationNumber) {
        return  urlEndpointService.allPhoneByFirestation(firestationNumber);
    }

    // URL 4 fire
    @GetMapping(value = "/fire{address}")
    public PersonListByAddress allPersonsByAddress(@PathVariable String address) throws ParseException {
        return urlEndpointService.allPersonsByAddress(address);
    }

    // URL 5 flood
//    @GetMapping(value = "/flood/stations{listofstationNumber")
//    public FamilyListByStation allFamilyByStation(@PathVariable String address) throws ParseException {
//        return urlEndpointService.allFamilyByStation(address);
//    }

    // URL 6 personinfo
//    @GetMapping(value = "/personInfo{lastName}")
//    public PersonInfoListDto allPersonInfo(@PathVariable String firstNameAndLastName) throws ParseException {
//        return  urlEndpointService.allPersonInfo(firstNameAndLastName);
//    }

    //URL 7 communityEmail
//    @GetMapping(value = "/communityEmail{city}")
//    public EmailListDto listEmailByCity(@PathVariable String city) {
//
//        List<String> email = new ArrayList<String>();
//        for (PersonDto personDto : urlEndpointService.allEmailByCity(city)) {
//            email.add(personDto.getEmail());
//        }
//        return urlEndpointService.allEmailByCity(city);
//    }

}

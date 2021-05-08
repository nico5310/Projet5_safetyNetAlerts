package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.dto.url1firestation.PersonsByStationDto;
import com.nico5310.safetyNetAlerts.dto.url2childAlert.ChildByAddressDto;
import com.nico5310.safetyNetAlerts.dto.url3phoneAlert.PhoneAlertListDto;
import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class UrlEndpointService {

    @Autowired
    PersonServiceInterface personServiceInterface;
    @Autowired
    FirestationServiceInterface firestationServiceInterface;
    @Autowired
    MedicalrecordServiceInterface medicalrecordServiceInterface;

    // URL 1 firestation
    public PersonsByStationDto allPersonsByStation(int stationNumber) throws ParseException {

        Calculator calculator = new Calculator();
        List<Person> listPers   = new ArrayList<Person>();
        for (Firestation firestation : firestationServiceInterface.findAddressByStation(stationNumber)) {
            List<Person> listPerson = personServiceInterface.findByAddress(firestation.getAddress());
            listPerson.addAll(listPers);

            for (Person person : listPerson) {
                Medicalrecord medicalrecord = medicalrecordServiceInterface.findByFirstName(person.getFirstName());
                calculator.calculateAge(medicalrecord.getBirthdate());
            }
        }
        return new PersonsByStationDto(listPers, calculator.getAdults(), calculator.getChildren());

    }

    // URL 2 childAlerts
    public ChildByAddressDto allChildByAddress(String address) throws ParseException {

        List<Person> listPers = new ArrayList<Person>();
        List<Person> listChildByAddress = new ArrayList<Person>();
        listPers.addAll(listChildByAddress);

        Calculator calculator = new Calculator();
        List<Medicalrecord> listMedicalrecord = new ArrayList<Medicalrecord>();
        for (Person person : listChildByAddress) {
            Medicalrecord medicalrecord = medicalrecordServiceInterface.findByFirstName(person.getFirstName());
            listMedicalrecord.add(medicalrecord);
            calculator.calculateAge(medicalrecord.getBirthdate());
        }
        return  new ChildByAddressDto(listPers, listMedicalrecord, calculator.getListAgeCalculate(), calculator.getChildren());

    }

    // URL 3 phoneAlert
    public PhoneAlertListDto allPhoneByFirestation(int firestation) {

        List<Person> listPers   = new ArrayList<Person>();
        List<String> listPhoneNumbers = new ArrayList<String>();
        for (Firestation station = firestationServiceInterface.findAddressByStation(firestation)) {
            listPers.addAll(personServiceInterface.findByAddress(station.getAddress()));
        }
        for (Person person : listPers) {
            listPhoneNumbers.add(person.getPhone());
        }
        return new PhoneAlertListDto(listPhoneNumbers);
    }

    // URL 4 fire




    // URL 5 flood




    // URL 6 personinfo




     //URL 7 communityEmail



    }

    //URL 7 communityEmail




}

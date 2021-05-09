package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.dto.url1firestation.PersonsByStationDto;
import com.nico5310.safetyNetAlerts.dto.url2childAlert.ChildByAddressDto;
import com.nico5310.safetyNetAlerts.dto.url3phoneAlert.PhoneAlertListDto;
import com.nico5310.safetyNetAlerts.dto.url4fire.PersonListByAddress;
import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.model.Person;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UrlEndpointService {

    @Autowired
    PersonServiceInterface personServiceInterface;
    @Autowired
    FirestationServiceInterface firestationServiceInterface;
    @Autowired
    MedicalrecordServiceInterface medicalrecordServiceInterface;

    /**
     * Constructor UrlEndpointService
     *      */
    public UrlEndpointService(PersonServiceInterface personServiceInterface, FirestationServiceInterface firestationServiceInterface, MedicalrecordServiceInterface medicalrecordServiceInterface) {

        this.personServiceInterface        = personServiceInterface;
        this.firestationServiceInterface   = firestationServiceInterface;
        this.medicalrecordServiceInterface = medicalrecordServiceInterface;
    }

    // URL 1 firestation
    public PersonsByStationDto allPersonsByStation(int stationNumber)  {

        Calculator calculator = new Calculator();
        List<Person> listPersons   = new ArrayList<Person>();
        for (Firestation firestation1 : firestationServiceInterface.findAddressByStation(stationNumber)) {
            List<Person> listPerson1 = personServiceInterface.findByAddress(firestation1.getAddress());
            listPerson1.addAll(listPersons);

            for (Person person : listPerson1) {
                Medicalrecord medicalrecord = medicalrecordServiceInterface.findByFirstName(person.getFirstName());
                calculator.calculateAge(medicalrecord.getBirthdate());
            }
        }
        return new PersonsByStationDto(listPersons, calculator.getAdults(), calculator.getChildren());

    }

    // URL 2 childAlerts
    public ChildByAddressDto allChildByAddress(String address)  {

        List<Person> listPersons = new ArrayList<Person>();
        List<Person> listPerson2 = personServiceInterface.findByAddress(address);
        listPersons.addAll(listPerson2);

        Calculator calculator = new Calculator();
        List<Medicalrecord> listMedicalrecords = new ArrayList<Medicalrecord>();
        for (Person person : listPerson2) {
            Medicalrecord medicalrecord = medicalrecordServiceInterface.findByFirstName(person.getFirstName());
            listMedicalrecords.add(medicalrecord);
            calculator.calculateAge(medicalrecord.getBirthdate());
        }
        return  new ChildByAddressDto(listPersons, listMedicalrecords, calculator.getListAgeCalculate(), calculator.getChildren());

    }

    // URL 3 phoneAlert
    public PhoneAlertListDto allPhoneByFirestation(int firestation) {

        List<Person> listPersons   = new ArrayList<Person>();
        List<String> listPhones = new ArrayList<String>();
        for (Firestation firestation2 : firestationServiceInterface.findAddressByStation(firestation)) {
            listPersons.addAll(personServiceInterface.findByAddress(firestation2.getAddress()));
        }
        for (Person person : listPersons) {
            listPhones.add(person.getPhone());
        }
        return  new PhoneAlertListDto(listPhones);

    }

    // URL 4 fire
    public PersonListByAddress allPersonsByAddress(String address) {

        Firestation  firestation      = firestationServiceInterface.findById(address);
        List<Person> listPersons         = new ArrayList<Person>();
        List<Person> listPersons3 = personServiceInterface.findByAddress(firestation.getAddress());
        listPersons.addAll(listPersons3);

        Calculator          calculator        = new Calculator();
        List<Medicalrecord> listMedicalrecord = new ArrayList<Medicalrecord>();
        for (Person person : listPersons3) {
            Medicalrecord medicalrecord = medicalrecordServiceInterface.findByFirstName(person.getFirstName());
            listMedicalrecord.add(medicalrecord);
            calculator.calculateAge(medicalrecord.getBirthdate());
        }

        return new PersonListByAddress(listPersons, listMedicalrecord, calculator.getListAgeCalculate(), firestation);

    }



    // URL 5 flood




    // URL 6 personinfo




     //URL 7 communityEmail





    //URL 7 communityEmail



}

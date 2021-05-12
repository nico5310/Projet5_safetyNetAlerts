package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.dto.url1firestation.PersonsByFirestation;
import com.nico5310.safetyNetAlerts.dto.url1firestation.PersonsByStationDto;
import com.nico5310.safetyNetAlerts.dto.url2childAlert.ChildByAddressDto;
import com.nico5310.safetyNetAlerts.dto.url3phoneAlert.PhoneAlertListDto;
import com.nico5310.safetyNetAlerts.dto.url4fire.PersonListByAddress;
import com.nico5310.safetyNetAlerts.dto.url5flood.FamilyListByStation;
import com.nico5310.safetyNetAlerts.dto.url6personInfo.PersonInfoDto;
import com.nico5310.safetyNetAlerts.dto.url7communityEmail.EmailListDto;
import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.model.Person;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UrlEndpointService {

    @Autowired
    PersonServiceInterface        personServiceInterface;
    @Autowired
    FirestationServiceInterface   firestationServiceInterface;
    @Autowired
    MedicalrecordServiceInterface medicalrecordServiceInterface;


    /**
     * Constructor UrlEndpointService
     */
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
            listPersons.addAll(listPerson1);

            for (Person person : listPerson1) {
                Medicalrecord medicalrecord = medicalrecordServiceInterface.findByFirstName(person.getFirstName());
                calculator.calculateAge(medicalrecord.getBirthdate());
            }
        }
        return new PersonsByStationDto(listPersons, calculator.getAdults(), calculator.getChildren());

    }



    // URL 2 childAlerts
    public ChildByAddressDto allChildByAddress(String address) {

        List<Person> listPerson2 = personServiceInterface.findByAddress(address);
        List<Person> listPersons = new ArrayList<>(listPerson2);

        Calculator          calculator         = new Calculator();
        List<Medicalrecord> listMedicalrecords = new ArrayList<>();
        for (Person person : listPerson2) {
            Medicalrecord medicalrecord = medicalrecordServiceInterface.findByFirstName(person.getFirstName());
            listMedicalrecords.add(medicalrecord);
            calculator.calculateAge(medicalrecord.getBirthdate());
        }
        return new ChildByAddressDto(listPersons, listMedicalrecords, calculator.getListAgeCalculate(), calculator.getChildren());

    }

    // URL 3 phoneAlert
    public PhoneAlertListDto allPhoneByFirestation(int station) {

        List<Person> listPersons = new ArrayList<>();
        List<String> listPhones  = new ArrayList<>();
        for (Firestation firestation2 : firestationServiceInterface.findAddressByStation(station)) {
            listPersons.addAll(personServiceInterface.findByAddress(firestation2.getAddress()));
        }
        for (Person person : listPersons) {
            listPhones.add(person.getPhone());
        }
        return new PhoneAlertListDto(listPhones);

    }

    // URL 4 fire
    public PersonListByAddress allPersonsByAddress(String address) {

        Firestation  firestation  = firestationServiceInterface.findById(address);
        List<Person> listPersons3 = personServiceInterface.findByAddress(firestation.getAddress());
        List<Person> listPersons  = new ArrayList<>(listPersons3);

        Calculator          calculator        = new Calculator();
        List<Medicalrecord> listMedicalrecord = new ArrayList<>();
        for (Person person : listPersons3) {
            Medicalrecord medicalrecord = medicalrecordServiceInterface.findByFirstName(person.getFirstName());
            listMedicalrecord.add(medicalrecord);
            calculator.calculateAge(medicalrecord.getBirthdate());
        }

        return new PersonListByAddress(listPersons, listMedicalrecord, calculator.getListAgeCalculate(), firestation);

    }


    // URL 5 flood
    public FamilyListByStation allFamilyByStation(int stationNumber) {

       Calculator calculator = new Calculator();
       List<Person> listPersons = new ArrayList<>();
       for (Firestation firestation : firestationServiceInterface.findAddressByStation(stationNumber)) {
           List<Person> listPersons2 = personServiceInterface.findByAddress(firestation.getAddress());
           listPersons.addAll(listPersons2);
       }
       List<Medicalrecord> listMedicalrecord = new ArrayList<>();
       for (Person person : listPersons) {
           Medicalrecord medicalrecord = medicalrecordServiceInterface.findByFirstName(person.getFirstName());
           listMedicalrecord.add(medicalrecord);
           calculator.calculateAge(medicalrecord.getBirthdate());
       }
       return new FamilyListByStation(listPersons, listMedicalrecord, calculator.getListAgeCalculate());


    }

    // URL 6 personinfo
    public PersonInfoDto allPersonInfo (String firstName, String lastName) throws ParseException {

        List<Person> listPersons2 = personServiceInterface.findByLastName(lastName);
        List<Person> listPersons = new ArrayList<>(listPersons2);


        Calculator calculator = new Calculator();
        List<Medicalrecord> listMedicalrecord = new ArrayList<>();
        for (Person person : listPersons) {
            Medicalrecord medicalrecord = medicalrecordServiceInterface.findByFirstName(person.getFirstName());
            listMedicalrecord.add(medicalrecord);
            calculator.calculateAge(medicalrecord.getBirthdate());
        }
        return new PersonInfoDto(listPersons, listMedicalrecord,calculator.getListAgeCalculate());

    }

    //URL 7 communityEmail
    public EmailListDto allEmailsByCity(String city) {

        List<Person> listPersons = personServiceInterface.findEmailByCity(city);
        List<String> emailList = new ArrayList<>();
        for (Person person : listPersons) {
            emailList.add(person.getEmail());
        }
        return new EmailListDto(emailList);

    }




}

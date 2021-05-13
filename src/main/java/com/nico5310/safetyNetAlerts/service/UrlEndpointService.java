package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.dto.url1firestation.PersonsByStationDto;
import com.nico5310.safetyNetAlerts.dto.url2childAlert.PersonsWithAge;
import com.nico5310.safetyNetAlerts.dto.url2childAlert.ChildByAddressDto;
import com.nico5310.safetyNetAlerts.dto.url3phoneAlert.PhoneAlertListDto;
import com.nico5310.safetyNetAlerts.dto.url4fire.PersonFireAddress;
import com.nico5310.safetyNetAlerts.dto.url4fire.PersonListByAddress;
import com.nico5310.safetyNetAlerts.dto.url5flood.FamilyListByStation;
import com.nico5310.safetyNetAlerts.dto.url6personInfo.PersonInfoDto;
import com.nico5310.safetyNetAlerts.dto.url7communityEmail.EmailListDto;
import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.model.Person;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.list.PredicatedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
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
    public PersonsByStationDto allPersonsByStation(int stationNumber) throws ParseException {

        Calculator   calculator  = new Calculator();
        List<Person> listPersonsStation = new ArrayList<Person>();
        for (Firestation firestation1 : firestationServiceInterface.findAddressByStation(stationNumber)) {
            List<Person> listPerson1 = personServiceInterface.findByAddress(firestation1.getAddress());
            listPersonsStation.addAll(listPerson1);

            for (Person person : listPerson1) {
                Medicalrecord medicalrecord = medicalrecordServiceInterface.findByFirstName(person.getFirstName());
                calculator.calculateAge(medicalrecord.getBirthdate());
            }
        }
        return new PersonsByStationDto(listPersonsStation, calculator.getAdults(), calculator.getChildren());

    }

    // URL 2 childAlerts
    public ChildByAddressDto allChildByAddress(String address) throws ParseException {

        ChildByAddressDto    childByAddressDto    = new ChildByAddressDto();
        List<PersonsWithAge> childList            = new ArrayList<>();
        List<PersonsWithAge> adultsList           = new ArrayList<>();
        List<Person>         listPersonsByAddress = personServiceInterface.findByAddress(address);

        Calculator          calculator         = new Calculator();
        List<Medicalrecord> listMedicalrecords = new ArrayList<Medicalrecord>();
        for (Person person : listPersonsByAddress) {
            Medicalrecord medicalrecord = medicalrecordServiceInterface.findByFirstName(person.getFirstName());
            listMedicalrecords.add(medicalrecord);
            calculator.calculateAge(medicalrecord.getBirthdate());

            PersonsWithAge personsWithAge = new PersonsWithAge(person.getFirstName(), person.getLastName(), calculator
                    .getAge());
            if (personsWithAge.getAge() < 18) {
                childList.add(personsWithAge);
            } else {
                adultsList.add(personsWithAge);
            }
        }
        childByAddressDto.setChildren(childList);
        childByAddressDto.setAdults(adultsList);
        return childByAddressDto;

    }

    // URL 3 phoneAlert
    public PhoneAlertListDto allPhoneByFirestation(int firestation) {

        List<Person> listPersons = new ArrayList<>();
        List<String> listPhones  = new ArrayList<>();
        for (Firestation firestation2 : firestationServiceInterface.findAddressByStation(firestation)) {
            listPersons.addAll(personServiceInterface.findByAddress(firestation2.getAddress()));
        }
        for (Person person : listPersons) {
            listPhones.add(person.getPhone());
        }
        return new PhoneAlertListDto(listPhones);

    }

    // URL 4 fire
    public PersonListByAddress allPersonsByAddress(String address) {

        Firestation firestationNumber  = firestationServiceInterface.findById(address);

        List<Person> listPersons3 = personServiceInterface.findByAddress(firestationNumber.getAddress());
        List<Person> listPersons  = new ArrayList<>(listPersons3);
        List<PersonFireAddress> listPersonsByAddress= new ArrayList<>();

        Calculator calculator = new Calculator();
        for (Person person : listPersons) {
            Medicalrecord medicalrecord = medicalrecordServiceInterface.findByFirstName(person.getFirstName());
            calculator.calculateAge(medicalrecord.getBirthdate());
            listPersonsByAddress.add(new PersonFireAddress(person.getLastName(), person.getPhone(), calculator.getAge(),  medicalrecord.getMedications(), medicalrecord.getAllergies()));

        }
        return new PersonListByAddress(firestationNumber, listPersonsByAddress);
    }

    // URL 5 flood
    public List<FamilyListByStation> allFamilyByStation(List<Integer> stations) {

        List<FamilyListByStation> familyListByStationList = new ArrayList<>();
        Calculator                calculator              = new Calculator();
        List<Person>              listPersons             = new ArrayList<>();

        for (Integer station : stations) {

            for (Firestation firestation : firestationServiceInterface.findAddressByStation(station)) {
                List<Person> listPersons2 = personServiceInterface.findByAddress(firestation.getAddress());
                listPersons.addAll(listPersons2);
            }

            List<Medicalrecord> listMedical = new ArrayList<>();
            for (Person person : listPersons) {
                Medicalrecord medicalrecord = medicalrecordServiceInterface.findByFirstName(person.getFirstName());
                listMedical.add(medicalrecord);
                calculator.calculateAge(medicalrecord.getBirthdate());

                familyListByStationList.add(new FamilyListByStation(person.getLastName(), person.getPhone(), calculator.getAge(), medicalrecord
                        .getMedications(), medicalrecord.getAllergies()));
            }
        }
        return familyListByStationList;
    }

    // URL 6 personinfo
    public List<PersonInfoDto> allPersonInfo(String firstName, String lastName) {

        List<Person> listPersons2 = personServiceInterface.findByLastName(lastName);
        List<Person> listPersons  = new ArrayList<>(listPersons2);
        List<PersonInfoDto> personInfoDtoList = new ArrayList<>();

        Calculator calculator = new Calculator();
        for (Person person : listPersons) {
            Medicalrecord medicalrecord = medicalrecordServiceInterface.findByFirstName(person.getFirstName());
            calculator.calculateAge(medicalrecord.getBirthdate());
            personInfoDtoList.add(new PersonInfoDto(person.getLastName(), person.getAddress(), person.getAge(), person.getEmail(), medicalrecord.getMedications(), medicalrecord.getAllergies()));
        }
        return personInfoDtoList;

    }

    //URL 7 communityEmail
    public EmailListDto allEmailsByCity(String city) {

        List<Person> listPersons = new ArrayList<>();
        List<String> listEmails   = new ArrayList<>();
        for (Person person : personServiceInterface.findEmailByCity(city)) {
            listPersons.add(person);
        }
        for (Person person : listPersons) {
            listEmails.add(person.getEmail());
        }
        return new EmailListDto(listEmails);

    }


}

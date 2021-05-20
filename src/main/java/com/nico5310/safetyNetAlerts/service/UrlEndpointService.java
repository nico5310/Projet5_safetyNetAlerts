package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.dto.url1firestation.PersonsByFirestation;
import com.nico5310.safetyNetAlerts.dto.url1firestation.PersonsByStationDto;
import com.nico5310.safetyNetAlerts.dto.url2childAlert.ChildByAddressDto;
import com.nico5310.safetyNetAlerts.dto.url2childAlert.PersonsWithAge;
import com.nico5310.safetyNetAlerts.dto.url3phoneAlert.PhoneAlertListDto;
import com.nico5310.safetyNetAlerts.dto.url4fire.PersonFireAddress;
import com.nico5310.safetyNetAlerts.dto.url4fire.PersonListByAddress;
import com.nico5310.safetyNetAlerts.dto.url5flood.FamilyListByStation;
import com.nico5310.safetyNetAlerts.dto.url6personInfo.PersonInfoDto;
import com.nico5310.safetyNetAlerts.dto.url7communityEmail.EmailListDto;
import com.nico5310.safetyNetAlerts.exceptions.NoFoundException;
import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.model.Person;
import com.nico5310.safetyNetAlerts.repository.FirestationRepositoryInterface;
import com.nico5310.safetyNetAlerts.repository.MedicalrecordRepositoryInterface;
import com.nico5310.safetyNetAlerts.repository.PersonRepositoryInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class UrlEndpointService {

    @Autowired
    PersonRepositoryInterface        personRepositoryInterface;
    @Autowired
    FirestationRepositoryInterface   firestationRepositoryInterface;
    @Autowired
    MedicalrecordRepositoryInterface medicalrecordRepositoryInterface;


    public UrlEndpointService(PersonRepositoryInterface personRepositoryInterface, FirestationRepositoryInterface firestationRepositoryInterface, MedicalrecordRepositoryInterface medicalrecordRepositoryInterface) {

        this.personRepositoryInterface      = personRepositoryInterface;
        this.firestationRepositoryInterface = firestationRepositoryInterface;
        this.medicalrecordRepositoryInterface  = medicalrecordRepositoryInterface;
    }


    // URL 1 firestation
    public PersonsByStationDto allPersonsByStation(int stationNumber) throws ParseException {

        Calculator   calculator         = new Calculator();
        List<Person> listPersonsStation = new ArrayList<Person>();
        for (Firestation firestation1 : firestationRepositoryInterface.findAddressByStation(stationNumber)) {
            List<Person> listPerson1 = personRepositoryInterface.findByAddress(firestation1.getAddress());
            listPersonsStation.addAll(listPerson1);

            for (Person person : listPerson1) {
                Medicalrecord medicalrecord = medicalrecordRepositoryInterface.findByFirstName(person.getFirstName());
                calculator.calculateAge(medicalrecord.getBirthdate());
            }
        }
        log.info("allPersonsByStation SUCCESS :" + stationNumber);
        return new PersonsByStationDto(listPersonsStation, calculator.getAdults(), calculator.getChildren());
    }


    // URL 2 childAlerts
    public ChildByAddressDto allChildByAddress(String address) throws ParseException {

        List<Person>         listPersonsByAddress = personRepositoryInterface.findByAddress(address);
        ChildByAddressDto    childByAddressDto    = new ChildByAddressDto();
        List<PersonsWithAge> childList            = new ArrayList<>();
        List<PersonsWithAge> adultsList           = new ArrayList<>();

        Calculator          calculator         = new Calculator();
        List<Medicalrecord> listMedicalrecords = new ArrayList<Medicalrecord>();
        for (Person person : listPersonsByAddress) {
            Medicalrecord medicalrecord = medicalrecordRepositoryInterface.findByFirstName(person.getFirstName());
            listMedicalrecords.add(medicalrecord);
            calculator.calculateAge(medicalrecord.getBirthdate());

            PersonsWithAge personsWithAge = new PersonsWithAge(person.getFirstName(), person.getLastName(), calculator.getAge());
            if (calculator.getAge() == 0) {
                return null;
            } else {
                if (personsWithAge.getAge() < 18) {
                    childList.add(personsWithAge);
                } else {
                    adultsList.add(personsWithAge);
                }
            }

        }
        childByAddressDto.setChildren(childList);
        childByAddressDto.setAdults(adultsList);
        log.info("allChildByAddress SUCCESS :" + address);
        return childByAddressDto;
    }

    // URL 3 phoneAlert
    public PhoneAlertListDto allPhoneByFirestation(int firestation) {

        List<Person> listPersons = new ArrayList<>();
        List<String> listPhones  = new ArrayList<>();
        for (Firestation firestation2 : firestationRepositoryInterface.findAddressByStation(firestation)) {
            listPersons.addAll(personRepositoryInterface.findByAddress(firestation2.getAddress()));
        }
        for (Person person : listPersons) {
            listPhones.add(person.getPhone());
        }
        log.info("allPhoneByFirestation SUCCESS :" + firestation);
        return new PhoneAlertListDto(listPhones);
    }

    // URL 4 fire
    public PersonListByAddress allPersonsByAddress(String address) {

        Firestation firestationNumber = firestationRepositoryInterface.findById(address);

        if (firestationNumber != null) {
            List<Person>            listPersons3         = personRepositoryInterface.findByAddress(firestationNumber.getAddress());
            List<Person>            listPersons          = new ArrayList<>(listPersons3);
            List<PersonFireAddress> listPersonsByAddress = new ArrayList<>();

            Calculator calculator = new Calculator();
            for (Person person : listPersons) {
                Medicalrecord medicalrecord = medicalrecordRepositoryInterface.findByFirstName(person.getFirstName());
                calculator.calculateAge(medicalrecord.getBirthdate());
                listPersonsByAddress.add(new PersonFireAddress(person.getLastName(), person.getPhone(), calculator.getAge(), medicalrecord
                        .getMedications(), medicalrecord.getAllergies()));

            }
            log.info("allPersonsByStation SUCCESS :" + address);
            return new PersonListByAddress(firestationNumber, listPersonsByAddress);
        } else { throw new NoFoundException("allPersonsByAddress dont exist :" + address); }
    }

    // URL 5 flood
    public List<FamilyListByStation> allFamilyByStation(List<Integer> stations) {

        List<FamilyListByStation> familyListByStationList = new ArrayList<>();
        Calculator                calculator              = new Calculator();
        List<Person>              listPersons             = new ArrayList<>();

        for (Integer station : stations) {

            for (Firestation firestation : firestationRepositoryInterface.findAddressByStation(station)) {
                List<Person> listPersons2 = personRepositoryInterface.findByAddress(firestation.getAddress());
                listPersons.addAll(listPersons2);
            }

            List<Medicalrecord> listMedical = new ArrayList<>();
            for (Person person : listPersons) {
                Medicalrecord medicalrecord = medicalrecordRepositoryInterface.findByFirstName(person.getFirstName());
                listMedical.add(medicalrecord);
                calculator.calculateAge(medicalrecord.getBirthdate());

                familyListByStationList.add(new FamilyListByStation(person.getLastName(), person.getPhone(), calculator.getAge(), medicalrecord
                        .getMedications(), medicalrecord.getAllergies()));
            }
        }
        log.info("allPersonsByStation SUCCESS :" + stations);
        return familyListByStationList;
    }

    // URL 6 personinfo
    public List<PersonInfoDto> allPersonInfo(String firstName, String lastName) throws ParseException {

        List<Person>        listPersons2      = personRepositoryInterface.findByFirstNameAndLastName(firstName, lastName);
        List<Person>        listPersons       = new ArrayList<Person>(listPersons2);
        List<PersonInfoDto> personInfoDtoList = new ArrayList<PersonInfoDto>();

        Calculator calculator = new Calculator();
        for (Person person : listPersons) {
            Medicalrecord medicalrecord = medicalrecordRepositoryInterface.findByFirstName(person.getFirstName());
            calculator.calculateAge(medicalrecord.getBirthdate());
            personInfoDtoList.add(new PersonInfoDto(person.getLastName(), person.getAddress(), calculator.getAge(), person
                    .getEmail(), medicalrecord.getMedications(), medicalrecord.getAllergies()));
        }
        log.info("allPersonInfo SUCCESS :" + (firstName + lastName));
        return personInfoDtoList;
    }

    //URL 7 communityEmail
    public EmailListDto allEmailsByCity(String city) {

        List<Person> listPersons = new ArrayList<>();
        List<String> listEmails  = new ArrayList<>();
        for (Person person : personRepositoryInterface.findEmailByCity(city)) {
            listPersons.add(person);
        }
        for (Person person : listPersons) {
            listEmails.add(person.getEmail());
        }
        log.info("allPersonsByStation SUCCESS :" + city);
        return new EmailListDto(listEmails);
    }


}

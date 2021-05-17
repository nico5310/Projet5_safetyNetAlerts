package com.nico5310.safetyNetAlerts.service;

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
    PersonServiceInterface        personServiceInterface;
    @Autowired
    FirestationServiceInterface   firestationServiceInterface;
    @Autowired
    MedicalrecordServiceInterface medicalrecordServiceInterface;


    public UrlEndpointService(PersonServiceInterface personServiceInterface, FirestationServiceInterface firestationServiceInterface, MedicalrecordServiceInterface medicalrecordServiceInterface) {

        this.personServiceInterface        = personServiceInterface;
        this.firestationServiceInterface   = firestationServiceInterface;
        this.medicalrecordServiceInterface = medicalrecordServiceInterface;
    }

    // URL 1 firestation
    public PersonsByStationDto allPersonsByStation(int stationNumber) throws ParseException {

        try {
            Calculator   calculator         = new Calculator();
            List<Person> listPersonsStation = new ArrayList<Person>();
            for (Firestation firestation1 : firestationServiceInterface.findAddressByStation(stationNumber)) {
                List<Person> listPerson1 = personServiceInterface.findByAddress(firestation1.getAddress());
                listPersonsStation.addAll(listPerson1);

                for (Person person : listPerson1) {
                    Medicalrecord medicalrecord = medicalrecordServiceInterface.findByFirstName(person.getFirstName());
                    calculator.calculateAge(medicalrecord.getBirthdate());
                }
            }
            log.info("allPersonsByStation SUCCESS :" + stationNumber);
            return new PersonsByStationDto(listPersonsStation, calculator.getAdults(), calculator.getChildren());
        } catch (NullPointerException nullPointerException) {
            log.error("allPersonsByStation dont exist :" + stationNumber);
        }
        return null;
    }


    // URL 2 childAlerts
    public ChildByAddressDto allChildByAddress(String address) throws ParseException {

        try {
            List<Person> listPersonsByAddress = personServiceInterface.findByAddress(address);
            ChildByAddressDto    childByAddressDto = new ChildByAddressDto();
            List<PersonsWithAge> childList         = new ArrayList<>();
            List<PersonsWithAge> adultsList        = new ArrayList<>();

            Calculator          calculator         = new Calculator();
            List<Medicalrecord> listMedicalrecords = new ArrayList<Medicalrecord>();
            for (Person person : listPersonsByAddress) {
                Medicalrecord medicalrecord = medicalrecordServiceInterface.findByFirstName(person.getFirstName());
                listMedicalrecords.add(medicalrecord);
                calculator.calculateAge(medicalrecord.getBirthdate());

                PersonsWithAge personsWithAge = new PersonsWithAge(person.getFirstName(), person.getLastName(), calculator
                        .getAge());
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
        } catch (NoFoundException noFoundException) {
            log.error("allChildByAddress dont exist :" + address);
        }
        return null;

    }

    // URL 3 phoneAlert
    public PhoneAlertListDto allPhoneByFirestation(int firestation) {

        try {
            List<Person> listPersons = new ArrayList<>();
            List<String> listPhones  = new ArrayList<>();
            for (Firestation firestation2 : firestationServiceInterface.findAddressByStation(firestation)) {
                listPersons.addAll(personServiceInterface.findByAddress(firestation2.getAddress()));
            }
            for (Person person : listPersons) {
                listPhones.add(person.getPhone());
            }
            log.info("allPhoneByFirestation SUCCESS :" + firestation);
            return new PhoneAlertListDto(listPhones);
        } catch (Exception exception) {
            log.error("allPhoneByFirestation dont exist :" + firestation);
        }
        return null;
    }

    // URL 4 fire
    public PersonListByAddress allPersonsByAddress(String address) {

        Firestation firestationNumber = firestationServiceInterface.findById(address);

        if (firestationNumber != null) {
            List<Person>            listPersons3         = personServiceInterface.findByAddress(firestationNumber.getAddress());
            List<Person>            listPersons          = new ArrayList<>(listPersons3);
            List<PersonFireAddress> listPersonsByAddress = new ArrayList<>();

            Calculator calculator = new Calculator();
            for (Person person : listPersons) {
                Medicalrecord medicalrecord = medicalrecordServiceInterface.findByFirstName(person.getFirstName());
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

        try {
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

                    familyListByStationList.add(new FamilyListByStation(person.getLastName(), person.getPhone(), calculator
                            .getAge(), medicalrecord.getMedications(), medicalrecord.getAllergies()));
                }
            }
            log.info("allPersonsByStation SUCCESS :" + stations);
            return familyListByStationList;
        } catch (NoFoundException noFoundException) {
            log.error("allFamilyByStation dont exist :" + stations);
        }
        return null;
    }

    // URL 6 personinfo
    public List<PersonInfoDto> allPersonInfo(String firstName, String lastName) throws ParseException {

        try {
            List<Person>        listPersons2      = personServiceInterface.findByFirstNameAndLastName(firstName, lastName);
            List<Person>        listPersons       = new ArrayList<Person>(listPersons2);
            List<PersonInfoDto> personInfoDtoList = new ArrayList<PersonInfoDto>();

            Calculator calculator = new Calculator();
            for (Person person : listPersons) {
                Medicalrecord medicalrecord = medicalrecordServiceInterface.findByFirstName(person.getFirstName());
                calculator.calculateAge(medicalrecord.getBirthdate());
                personInfoDtoList.add(new PersonInfoDto(person.getLastName(), person.getAddress(), calculator.getAge(), person
                        .getEmail(), medicalrecord.getMedications(), medicalrecord.getAllergies()));
            }
            log.info("allPersonInfo SUCCESS :" + (firstName + lastName));
            return personInfoDtoList;
        } catch (NoFoundException noFoundException) {
            log.error("allPersonInfo dont exist :" + (firstName + lastName));
        }
        return null;

    }

    //URL 7 communityEmail
    public EmailListDto allEmailsByCity(String city) {

        try {
            List<Person> listPersons = new ArrayList<>();
            List<String> listEmails  = new ArrayList<>();
            for (Person person : personServiceInterface.findEmailByCity(city)) {
                listPersons.add(person);
            }
            for (Person person : listPersons) {
                listEmails.add(person.getEmail());
            }
            log.info("allPersonsByStation SUCCESS :" + city);
            return new EmailListDto(listEmails);
        } catch (NoFoundException noFoundException) {
            log.error("allEmailsByCity dont exist :" + city);
        }
        return null;

    }


}

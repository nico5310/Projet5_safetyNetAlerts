package com.nico5310.safetyNetAlerts.service;

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
        List<Person> listPersons = new ArrayList<Person>();
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
    public List<ChildByAddressDto> allChildByAddress(String address) throws ParseException {

        List<ChildByAddressDto> childByAddressDtoList = new ArrayList<>();
        List<Person> listPersonsByAddress           = personServiceInterface.findByAddress(address);

        Calculator          calculator         = new Calculator();
        List<Medicalrecord> listMedicalrecords = new ArrayList<Medicalrecord>();
        for (Person person : listPersonsByAddress) {
                Medicalrecord medicalrecord = medicalrecordServiceInterface.findByFirstName(person.getFirstName());

                    listMedicalrecords.add(medicalrecord);
                    calculator.calculateAge(medicalrecord.getBirthdate());

                    childByAddressDtoList.add(new ChildByAddressDto(person.getFirstName(), person.getLastName(), calculator.getAge()));

        }
        return childByAddressDtoList;

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

        Firestation  firestation  = firestationServiceInterface.findById(address);
        List<Person> listPersons3 = personServiceInterface.findByAddress(firestation.getAddress());
        List<Person> listPersons  = new ArrayList<>(listPersons3);
        listPersons.addAll(listPersons3);

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

package com.nico5310.safetyNetAlerts.service;


import com.nico5310.safetyNetAlerts.dto.url1firestation.PersonsByFirestation;
import com.nico5310.safetyNetAlerts.dto.url2childAlert.ChildByAddressDto;
import com.nico5310.safetyNetAlerts.dto.url2childAlert.PersonsWithAge;
import com.nico5310.safetyNetAlerts.dto.url3phoneAlert.PhoneAlertListDto;
import com.nico5310.safetyNetAlerts.dto.url5flood.FamilyListByStation;
import com.nico5310.safetyNetAlerts.dto.url6personInfo.PersonInfoDto;
import com.nico5310.safetyNetAlerts.model.Database;
import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.model.Person;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UrlEndpointServiceTest {

    private UrlEndpointService urlEndpointService;

    @Mock
    private PersonServiceInterface personServiceInterface;

    @Mock
    private FirestationServiceInterface firestationServiceInterface;

    @Mock
    private MedicalrecordServiceInterface medicalrecordServiceInterface;

    @Mock
    private Calculator calculator = new Calculator();

    List<Person> listPersons;

    @Before
    public void setUp() {

        urlEndpointService = new UrlEndpointService(personServiceInterface, firestationServiceInterface, medicalrecordServiceInterface);
    }

    //URL 1
    @Test
    @DisplayName("Test allPersonsByStationUrlTest url endpoints")
    public void allPersonsByStationUrlTest() throws ParseException {
        //GIVEN
        listPersons = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("nicolas");
        person.setLastName("biancucci");
        person.setAddress("4 le village");
        person.setCity("thurigneux");
        person.setZip("01390");
        person.setPhone("061111111");
        person.setEmail("nico@gmail.com");
        listPersons.add(person);
        List<Firestation> firestationList = new ArrayList<>();
        Firestation       firestation     = new Firestation();
        firestation.setAddress("4 le village");
        firestation.setStation(7);
        firestationList.add(firestation);

        Medicalrecord medicalrecord = new Medicalrecord();
        List<String>  medications   = new ArrayList<>();
        medications.add("kestin");
        medications.add("doliprane");
        List<String> allergies = new ArrayList<>();
        allergies.add("gramines");
        allergies.add("pollen");
        medicalrecord.setFirstName("nicolas");
        medicalrecord.setLastName("biancucci");
        medicalrecord.setBirthdate("10/07/1980");
        medicalrecord.setMedications(medications);
        medicalrecord.setAllergies(allergies);

        //WHEN
        when(firestationServiceInterface.findAddressByStation(any(int.class))).thenReturn(firestationList);
        when(medicalrecordServiceInterface.findByFirstName(person.getFirstName())).thenReturn(medicalrecord);
        when(personServiceInterface.findByAddress("4 le village")).thenReturn(listPersons);
        assertNotNull(urlEndpointService.allPersonsByStation(2));

        //THEN
        for (Person person1 : urlEndpointService.allPersonsByStation(2).getListPersonsStation()) {
            assertThat(person1.getFirstName(), containsString("nicolas"));
        }
    }

    //    //URL 2
    //    @Test
    //    @DisplayName("Test allChildByAddressUrlTest url endpoints")
    //    public void allChildByAddressUrlTest() throws ParseException {
    //        //GIVEN
    //        listPersons = new ArrayList<>();
    //        Person person = new Person();
    //        person.setFirstName("nicolas");
    //        person.setLastName("biancucci");
    //        person.setAddress("4 le village");
    //        person.setCity("thurigneux");
    //        person.setZip("01390");
    //        person.setPhone("061111111");
    //        person.setEmail("nico@gmail.com");
    //        listPersons.add(person);
    //
    //        Medicalrecord medicalrecord = new Medicalrecord();
    //        List<String>  medications   = new ArrayList<>();
    //        medications.add("kestin");
    //        medications.add("doliprane");
    //        List<String> allergies = new ArrayList<>();
    //        allergies.add("gramines");
    //        allergies.add("pollen");
    //        medicalrecord.setFirstName("nicolas");
    //        medicalrecord.setLastName("biancucci");
    //        medicalrecord.setBirthdate("10/07/2014");
    //        medicalrecord.setMedications(medications);
    //        medicalrecord.setAllergies(allergies);
    //
    //        //WHEN
    //        when(personServiceInterface.findByAddress(any(String.class))).thenReturn(listPersons);
    //        when(medicalrecordServiceInterface.findByFirstName(any(String.class))).thenReturn(medicalrecord);
    //
    //        //THEN
    //        assertNull(urlEndpointService.allChildByAddress("4 le village"));
    //    }


    // URL 3
    @Test
    @DisplayName("Test allPhoneByFirestationUrlTest url endpoints")
    public void allPhoneByFirestationUrlTest() {
        //GIVEN
        listPersons = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("nicolas");
        person.setLastName("biancucci");
        person.setAddress("4 le village");
        person.setCity("thurigneux");
        person.setZip("01390");
        person.setPhone("061111111");
        person.setEmail("nico@gmail.com");
        listPersons.add(person);
        List<Firestation> firestationList = new ArrayList<>();
        Firestation       firestation     = new Firestation();
        firestation.setAddress("4 le village");
        firestation.setStation(7);
        firestationList.add(firestation);

        //WHEN
        when(firestationServiceInterface.findAddressByStation(7)).thenReturn(firestationList);
        when(personServiceInterface.findByAddress("4 le village")).thenReturn(listPersons);

        //THEN
        assertThat(urlEndpointService.allPhoneByFirestation(7)
                                     .getListPhonesCity()
                                     .toString(), containsString("061111111"));
    }
    //
    //    // URL 4
    //    @Test
    //    @DisplayName("Test allPersonsByAddressUrlTest url endpoint")
    //    public void allPersonsByAddressUrlTest() throws ParseException {
    //        //GIVEN
    //        listPersons = new ArrayList<>();
    //        Person person = new Person();
    //        person.setFirstName("nicolas");
    //        person.setLastName("biancucci");
    //        person.setAddress("le village");
    //        person.setCity("thurigneux");
    //        person.setZip("01390");
    //        person.setPhone("061111111");
    //        person.setEmail("nico@gmail.com");
    //        listPersons.add(person);
    //
    //        Firestation firestation = new Firestation();
    //        firestation.setAddress("4 le village");
    //        firestation.setStation(7);
    //
    //        Medicalrecord medicalrecord = new Medicalrecord();
    //        List<String>  medications   = new ArrayList<String>();
    //        medications.add("kestin");
    //        medications.add("doliprane");
    //        List<String> allergies = new ArrayList<String>();
    //        allergies.add("gramines");
    //        allergies.add("pollen");
    //        medicalrecord.setFirstName("nicolas");
    //        medicalrecord.setLastName("biancucci");
    //        medicalrecord.setBirthdate("10/07/1980");
    //        medicalrecord.setMedications(medications);
    //        medicalrecord.setAllergies(allergies);
    //
    //        //WHEN
    //        when(personServiceInterface.findByAddress("4 le village")).thenReturn(listPersons);
    //        when(medicalrecordServiceInterface.findByFirstName("nicolas")).thenReturn(medicalrecord);
    //        when(firestationServiceInterface.findById("4 le village")).thenReturn(firestation);
    //
    //        //THEN
    //        List<PersonsByFirestation> personsByFirestationList = urlEndpointService.allPersonsByAddress("4 le village");
    //        for (PersonsByFirestation personsByFirestation : personsByFirestationList) throws ParseException {
    //            assertThat(personsByFirestation.getFirstName(), containsString("ghazi"));
    //        }
    //
    //        //THEN
    //        assertThat(urlEndpointService.allPersonsByAddress("4 le village")
    //                                     .getFirestationNumber().getAddress(),.toString(), containsString("061111111"));
    //    }

    //URL 5
    @Test
    @DisplayName("Test allFamilyByStationUrlTest url endpoint")
    public void allFamilyByStationUrlTest() throws ParseException {
        //GIVEN
        listPersons = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("nicolas");
        person.setLastName("biancucci");
        person.setAddress("le village");
        person.setCity("thurigneux");
        person.setZip("01390");
        person.setPhone("061111111");
        person.setEmail("nico@gmail.com");
        listPersons.add(person);

        List<Firestation> firestationList = new ArrayList<Firestation>();
        Firestation       firestation     = new Firestation();
        firestation.setAddress("4 le village");
        firestation.setStation(7);
        firestationList.add(firestation);

        Medicalrecord medicalrecord = new Medicalrecord();
        List<String>  medications   = new ArrayList<String>();
        medications.add("kestin");
        medications.add("doliprane");
        List<String> allergies = new ArrayList<String>();
        allergies.add("gramines");
        allergies.add("pollen");
        medicalrecord.setFirstName("nicolas");
        medicalrecord.setLastName("biancucci");
        medicalrecord.setBirthdate("10/07/1980");
        medicalrecord.setMedications(medications);
        medicalrecord.setAllergies(allergies);

        List<Integer> stations = new ArrayList<>();
        stations.add(1);
        stations.add(2);

        //WHEN
        when(personServiceInterface.findByAddress("4 le village")).thenReturn(listPersons);
        when(medicalrecordServiceInterface.findByFirstName(person.getFirstName())).thenReturn(medicalrecord);
        when(firestationServiceInterface.findAddressByStation(any(int.class))).thenReturn(firestationList);

        //THEN
        List<FamilyListByStation> familyListByStationList = urlEndpointService.allFamilyByStation(stations);
        for (FamilyListByStation familyListByStation : familyListByStationList) {
            assertThat(familyListByStation.getLastName(), containsString("biancucci"));
        }
    }

    //URL 6
    @Test
    @DisplayName("Test allPersonInfoUrlTest url endpoint")
    public void allPersonInfoUrlTest() throws ParseException {
        //GIVEN
        listPersons = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("nicolas");
        person.setLastName("biancucci");
        person.setAddress("le village");
        person.setCity("thurigneux");
        person.setZip("01390");
        person.setPhone("061111111");
        person.setEmail("nico@gmail.com");
        listPersons.add(person);

        List<Firestation> firestationList = new ArrayList<Firestation>();
        Firestation       firestation     = new Firestation();
        firestation.setAddress("4 le village");
        firestation.setStation(7);
        firestationList.add(firestation);

        Medicalrecord medicalrecord = new Medicalrecord();
        List<String>  medications   = new ArrayList<String>();
        medications.add("kestin");
        medications.add("doliprane");
        List<String> allergies = new ArrayList<String>();
        allergies.add("gramines");
        allergies.add("pollen");
        medicalrecord.setFirstName("nicolas");
        medicalrecord.setLastName("biancucci");
        medicalrecord.setBirthdate("10/07/1980");
        medicalrecord.setMedications(medications);
        medicalrecord.setAllergies(allergies);

        //WHEN
        when(personServiceInterface.findByLastName("biancucci")).thenReturn(listPersons);
        when(medicalrecordServiceInterface.findByFirstName(person.getFirstName())).thenReturn(medicalrecord);

        //THEN

        for (PersonInfoDto personInfo : urlEndpointService.allPersonInfo("nicolas", "biancucci")) {
            assertThat(personInfo.getLastName(), containsString("biancucci"));
            assertThat(personInfo.getAddress(), containsString("4 le village"));
            assertThat(personInfo.getEmail(), containsString("nico@gmail.com"));
            assertThat(personInfo.getMedications().toString(), containsString(medications.toString()));
            assertThat(personInfo.getAllergies().toString(), containsString(allergies.toString()));

        }
    }


    //URL 7
    @Test
    @DisplayName("Test allEmailsByCity url endpoints")
    public void allEmailsByCity() {
        //GIVEN
        listPersons = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("nicolas");
        person.setLastName("biancucci");
        person.setAddress("le village");
        person.setCity("thurigneux");
        person.setZip("01390");
        person.setPhone("061111111");
        person.setEmail("nico@gmail.com");
        listPersons.add(person);

        //WHEN
        when(personServiceInterface.findEmailByCity("thurigneux")).thenReturn(listPersons);

        //THEN
        assertThat(urlEndpointService.allEmailsByCity("thurigneux")
                                     .getListEmails()
                                     .toString(), containsString("nico@gmail.com"));

    }


}

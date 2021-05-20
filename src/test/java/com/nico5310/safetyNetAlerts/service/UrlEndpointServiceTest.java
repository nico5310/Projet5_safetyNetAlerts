package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.dto.url2childAlert.PersonsWithAge;
import com.nico5310.safetyNetAlerts.dto.url4fire.PersonFireAddress;
import com.nico5310.safetyNetAlerts.dto.url5flood.FamilyListByStation;
import com.nico5310.safetyNetAlerts.dto.url6personInfo.PersonInfoDto;
import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.model.Person;
import com.nico5310.safetyNetAlerts.repository.FirestationRepositoryInterface;
import com.nico5310.safetyNetAlerts.repository.MedicalrecordRepositoryInterface;
import com.nico5310.safetyNetAlerts.repository.PersonRepositoryInterface;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UrlEndpointServiceTest {

    @Mock
    private static PersonRepositoryInterface personRepositoryInterface;

    @Mock
    private static FirestationRepositoryInterface firestationRepositoryInterface;

    @Mock
    private static MedicalrecordRepositoryInterface medicalrecordRepositoryInterface;

    @Mock
    private Calculator calculator = new Calculator();

    @InjectMocks
    private static UrlEndpointService urlEndpointService;

    List<Person> listPersons;

    @BeforeAll
    static void setUp() {

        urlEndpointService = new UrlEndpointService(personRepositoryInterface, firestationRepositoryInterface, medicalrecordRepositoryInterface);
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
        when(personRepositoryInterface.findByAddress("4 le village")).thenReturn(listPersons);
        when(firestationRepositoryInterface.findAddressByStation(any(int.class))).thenReturn(firestationList);
        when(medicalrecordRepositoryInterface.findByFirstName(person.getFirstName())).thenReturn(medicalrecord);

        assertNotNull(urlEndpointService.allPersonsByStation(2));

        //THEN
        for (Person person1 : urlEndpointService.allPersonsByStation(2).getListPersonsStation()) {
            assertThat(person1.getFirstName(), containsString("nicolas"));
        }
    }

    //URL 2
    @Test
    @DisplayName("Test allChildByAddressChildrenUrlTest for Children Type url endpoints")
    public void allChildByAddressChildrenUrlTest() throws ParseException {
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

        Medicalrecord medicalrecord = new Medicalrecord();
        List<String>  medications   = new ArrayList<>();
        medications.add("kestin");
        medications.add("doliprane");
        List<String> allergies = new ArrayList<>();
        allergies.add("gramines");
        allergies.add("pollen");
        medicalrecord.setFirstName("nicolas");
        medicalrecord.setLastName("biancucci");
        medicalrecord.setBirthdate("10/07/2014");
        medicalrecord.setMedications(medications);
        medicalrecord.setAllergies(allergies);

        when(personRepositoryInterface.findByAddress(any(String.class))).thenReturn(listPersons);
        when(medicalrecordRepositoryInterface.findByFirstName(any(String.class))).thenReturn(medicalrecord);

        //THEN
        for (PersonsWithAge childByAddressDto : urlEndpointService.allChildByAddress("4 le village").getChildren()) {
            assertThat(childByAddressDto.getFirstName(), containsString("nicolas"));
            assertThat(childByAddressDto.getLastName(), containsString("biancucci"));

        }
    }


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
        when(personRepositoryInterface.findByAddress("4 le village")).thenReturn(listPersons);
        when(firestationRepositoryInterface.findAddressByStation(7)).thenReturn(firestationList);


        //THEN
        assertThat(urlEndpointService.allPhoneByFirestation(7)
                                     .getListPhonesCity()
                                     .toString(), containsString("061111111"));
    }

    // URL 4
    @Test
    @DisplayName("Test allPersonsByAddressUrlTest url endpoint")
    public void allPersonsByAddressUrlTest() throws ParseException {
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

        Firestation firestation = new Firestation();
        firestation.setAddress("4 le village");
        firestation.setStation(7);

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
        when(personRepositoryInterface.findByAddress("4 le village")).thenReturn(listPersons);
        when(medicalrecordRepositoryInterface.findByFirstName("nicolas")).thenReturn(medicalrecord);
        when(firestationRepositoryInterface.findById("4 le village")).thenReturn(firestation);

        //THEN
        for (PersonFireAddress personListByAddress : urlEndpointService.allPersonsByAddress("4 le village")
                                                                       .getListPersonsByAddress()) {
            assertThat(personListByAddress.getLastName().toString(), containsString("biancucci"));
        }

    }

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
        when(personRepositoryInterface.findByAddress("4 le village")).thenReturn(listPersons);
        when(medicalrecordRepositoryInterface.findByFirstName(person.getFirstName())).thenReturn(medicalrecord);
        when(firestationRepositoryInterface.findAddressByStation(any(int.class))).thenReturn(firestationList);

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
        person.setAddress("4 le village");
        person.setCity("thurigneux");
        person.setZip("01390");
        person.setPhone("061111111");
        person.setEmail("nico@gmail.com");
        listPersons.add(person);

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
        when(personRepositoryInterface.findByFirstNameAndLastName("nicolas", "biancucci")).thenReturn(listPersons);
        when(medicalrecordRepositoryInterface.findByFirstName(person.getFirstName())).thenReturn(medicalrecord);

        //THEN

        for (PersonInfoDto personInfo : urlEndpointService.allPersonInfo("nicolas", "biancucci")) {
            assertThat(personInfo.getLastName(), containsString("biancucci"));
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
        when(personRepositoryInterface.findEmailByCity("thurigneux")).thenReturn(listPersons);

        //THEN
        assertThat(urlEndpointService.allEmailsByCity("thurigneux")
                                     .getListEmails()
                                     .toString(), containsString("nico@gmail.com"));

    }


}

package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Person;
import com.nico5310.safetyNetAlerts.repository.PersonRepositoryInterface;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {


    private PersonService personService;

    @Mock
    private PersonRepositoryInterface personRepositoryInterface;

    @Before
    public void setUp() throws Exception {
        personService = new PersonService(personRepositoryInterface);
    }


    @Test
    @DisplayName("Test findPersonAll with new person to list")
    public void findPersonAll() {
        //GIVEN
        List<Person> listPersons = new ArrayList<>();
        Person       person      = new Person();
        person.setFirstName("nicolas");
        person.setLastName("biancucci");
        person.setAddress("le village");
        person.setCity("thurigneux");
        person.setZip("01390");
        person.setPhone("061111111");
        person.setEmail("nico@gmail.com");
        listPersons.add(person);

        //WHEN
        when(personRepositoryInterface.findPersonAll()).thenReturn(listPersons);

        //THEN
        assertThat(personService.findPersonAll().toString(), containsString("nicolas"));
    }

    @Test
    @DisplayName("Test savePersonList with new person")
    public void savePersonList() {
        //GIVEN
        Person person = new Person();
        person.setFirstName("nicolas");
        person.setLastName("biancucci");
        person.setAddress("le village");
        person.setCity("thurigneux");
        person.setZip("01390");
        person.setPhone("061111111");
        person.setEmail("nicolas@gmail.com");
        List<Person> listPerson = new ArrayList<Person>();
        listPerson.add(person);

        //WHEN
        when(personRepositoryInterface.findPersonAll()).thenReturn(listPerson);
        personService.savePersonList(person);

        //THEN
        assertThat(personService.savePersonList(person).toString(), containsString("nicolas"));

    }

    @Test
    @DisplayName("Test updatePersonList with a exist person")
    public void updatePersonList() {
        //GIVEN
        Person person = new Person();
        person.setFirstName("nicolas");
        person.setLastName("biancucci");
        person.setAddress("le village");
        person.setCity("thurigneux");
        person.setZip("01390");
        person.setPhone("061111111");
        person.setEmail("nicolas@gmail.com");

        //WHEN
        when(personRepositoryInterface.updatePersonList("nicolasbiancucci", person)).thenReturn(person);

             //THEN
        assertThat(personService.updatePersonList("nicolasbiancucci", person).toString(), containsString("nicolas"));

    }

    @Test
    @DisplayName("Test deletePersonList with listPerson")
    public void deletePersonList() {
        //GIVEN
        Person person = new Person();
        person.setFirstName("nicolas");
        person.setLastName("biancucci");
        person.setAddress("le village");
        person.setCity("thurigneux");
        person.setZip("01390");
        person.setPhone("061111111");
        person.setEmail("nicolas@gmail.com");
        personService.savePersonList(person);

        //WHEN

        //THEN
        assertThat(personService.deletePersonList("nicolasbiancucci").toString(), containsString(""));

    }

    @Test
    @DisplayName("Test findByAddress")
    public void findByAddress() {
        //GIVEN
        Person person = new Person();
        person.setFirstName("nicolas");
        person.setLastName("biancucci");
        person.setAddress("le village");
        person.setCity("thurigneux");
        person.setZip("01390");
        person.setPhone("061111111");
        person.setEmail("nicolas@gmail.com");
        List<Person> listPerson = new ArrayList<Person>();
        listPerson.add(person);
        //WHEN
        when(personRepositoryInterface.findByAddress("4 le village")).thenReturn(listPerson);

        //THEN
        assertThat(personService.findByAddress("4 le village").toString(), containsString("nicolas"));
    }

    @Test
    @DisplayName("Test  findByLastName")
    public void findByLastName() {
        //GIVEN
        Person person = new Person();
        person.setFirstName("nicolas");
        person.setLastName("biancucci");
        person.setAddress("le village");
        person.setCity("thurigneux");
        person.setZip("01390");
        person.setPhone("061111111");
        person.setEmail("nicolas@gmail.com");
        List<Person> listPerson = new ArrayList<Person>();
        listPerson.add(person);

        //WHEN
        when(personRepositoryInterface.findByLastName("biancucci")).thenReturn(listPerson);

        //THEN
        assertThat(personService.findByLastName("biancucci").toString(), containsString("biancucci"));

    }

    @Test
    @DisplayName("Test  findByFirstNameAndLastName")
    public void findByFirstNameAndLastName() {
        //GIVEN
        Person person = new Person();
        person.setFirstName("nicolas");
        person.setLastName("biancucci");
        person.setAddress("le village");
        person.setCity("thurigneux");
        person.setZip("01390");
        person.setPhone("061111111");
        person.setEmail("nicolas@gmail.com");
        List<Person> listPerson = new ArrayList<Person>();
        listPerson.add(person);
        //WHEN
        when(personRepositoryInterface.findByFirstNameAndLastName("nicolas","biancucci")).thenReturn(listPerson);

        //THEN
        assertThat(personService.findByFirstNameAndLastName("nicolas","biancucci").toString(), containsString("biancucci"));

    }



}

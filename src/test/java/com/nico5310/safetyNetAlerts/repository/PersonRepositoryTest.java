package com.nico5310.safetyNetAlerts.repository;

import com.nico5310.safetyNetAlerts.model.Database;
import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.model.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonRepositoryTest {

    @Mock
    private Database database;

    @InjectMocks
    private PersonRepository personRepository;

    @Test
    @DisplayName("Test findPersonAllTest")
    public void findPersonAllTest() {
        //GIVEN
        List<Person> personList = new ArrayList<Person>();

        //WHEN
        when(database.getPersons()).thenReturn(personList);
        List<Person> findPersonAll = personRepository.findPersonAll();
        assertSame(personList, findPersonAll);
        assertTrue(findPersonAll.isEmpty());

        //THEN
        verify(database).getPersons();
    }

    @Test
    @DisplayName("Test savePersonListTest")
    public void savePersonListTest() {
        //GIVEN
        List<Person> personList = new ArrayList<Person>();

        //WHEN
        when(database.getPersons()).thenReturn(personList);
        List<Person> savePersonList = personRepository.savePersonList(new Person());
        assertSame(personList, savePersonList);
        assertEquals(1, savePersonList.size());

        //THEN
        verify(database).getPersons();
        assertSame(savePersonList, personRepository.findPersonAll());
    }

    @Test
    @DisplayName("Test updatePersonListTest")
    public void updatePersonListTest() {
        //GIVEN
        List<Person> personList = new ArrayList<Person>();

        //WHEN
        when(database.getPersons()).thenReturn(personList);
        assertNull(personRepository.updatePersonList("Nicolas", new Person()));

        //THEN
        verify(database).getPersons();
        assertSame(personList, personRepository.findPersonAll());
    }

    @Test
    @DisplayName("Test deletePersonListTest")
    public void deletePersonListTest() {
        //GIVEN
        List<Person> personList = new ArrayList<Person>();

        //WHEN
        when(database.getPersons()).thenReturn(personList);
        personRepository.deletePersonList("Nicolas");
        verify(database).getPersons();
        List<Person> findPersonAllResult = personRepository.findPersonAll();

        //THEN
        assertSame(personList, findPersonAllResult);
        assertTrue(findPersonAllResult.isEmpty());
    }

    @Test
    @DisplayName("Test findByAddressTEst")
    public void findByAddressTEst() {
        //GIVEN
        List<Person> personList = new ArrayList<Person>();

        //WHEN
        when(database.getPersons()).thenReturn(personList);
        assertTrue(personRepository.findByAddress("4 le village").isEmpty());

        //THEN
        verify(database).getPersons();
        assertSame(personList, personRepository.findPersonAll());
    }

    @Test
    @DisplayName("Test findByLastNameTest")
    public void findByLastNameTest() {
        //GIVEN
        List<Person> personList    = new ArrayList<Person>();
        Medicalrecord     medicalrecord = new Medicalrecord();
        personList.add(new Person("nicolas", "biancucci", "4 le village", "thurigneux", "01390", "0611111111", "nico@gmail.com", 40, medicalrecord, new Firestation(), "nicolasbiancucci"));

        //WHEN
        when(this.database.getPersons()).thenReturn(personList);
        assertEquals(1, this.personRepository.findByLastName("biancucci").size());

        //THEN
        verify(this.database).getPersons();
        assertSame(personList, this.personRepository.findPersonAll());
    }

    @Test
    @DisplayName("Test findByFirstNameAndLastNameTest")
    public void findByFirstNameAndLastNameTest() {
        //GIVEN
        List<Person> personList    = new ArrayList<Person>();
        Medicalrecord     medicalrecord = new Medicalrecord();
        personList.add(new Person("nicolas", "biancucci", "4 le village", "thurigneux", "01390", "0611111111", "nico@gmail.com", 40, medicalrecord, new Firestation(), "nicolasbiancucci"));

        //WHEN
        when(this.database.getPersons()).thenReturn(personList);
        assertEquals(1, this.personRepository.findByFirstNameAndLastName("nicolas", "biancucci").size());

        //THEN
        verify(this.database).getPersons();
        assertSame(personList, this.personRepository.findPersonAll());
    }


}


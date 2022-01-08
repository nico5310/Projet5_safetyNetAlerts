package com.nico5310.safetyNetAlerts.repository;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.nico5310.safetyNetAlerts.model.Database;
import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.model.Person;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
public class FirestationRepositoryTest {


    @Mock
    private Database database;

    @InjectMocks
    private FirestationRepository firestationRepository;



    @Test
    @DisplayName("Test findFirestationAllTest")
    public void findFirestationAllTest() {
        //GIEVEN
        List<Firestation> firestationList = new ArrayList<Firestation>();

        //WHEN
        when(database.getFirestations()).thenReturn(firestationList);
        List<Firestation> findFirestationAll = firestationRepository.findFirestationAll();
        assertSame(firestationList, findFirestationAll);
        //THEN
        assertTrue(findFirestationAll.isEmpty());
        verify(database).getFirestations();
    }



    @Test
    @DisplayName("Test saveFirestationListTest")
    public void saveFirestationListTest() {
        //GIVEN
        List<Firestation> firestationList = new ArrayList<Firestation>();

        //WHEN
        when(database.getFirestations()).thenReturn(firestationList);
        List<Firestation> saveFirestationList = firestationRepository.saveFirestationList(new Firestation());
        assertSame(firestationList, saveFirestationList);

        //THEN
        assertEquals(1, saveFirestationList.size());
        verify(this.database).getFirestations();
        assertSame(saveFirestationList, this.firestationRepository.findFirestationAll());
    }


    @Test
    @DisplayName("Test updateFirestationListTest")
    public void updateFirestationListTest() {
        //GIVEN
        Firestation firestation = new Firestation();
        firestation.setAddress("4 le village");
        List<Firestation> firestationList = new ArrayList<Firestation>();
        firestationList.add(firestation);

        //WHEN
        when(database.getFirestations()).thenReturn(firestationList);
        assertNull(firestationRepository.updateFirestationList(new Firestation()));

        //THEN
        verify(database).getFirestations();
        assertSame(firestationList, firestationRepository.findFirestationAll());
    }



    @Test
    @DisplayName("Test updateFirestationListTest")
    public void deleteFirestationListTest() {
        //GIVEN
        List<Firestation> firestationList = new ArrayList<Firestation>();
        firestationList.add(new Firestation("4 le village", 7, new ArrayList<Person>()));

        //WHEN
        when(database.getFirestations()).thenReturn(firestationList);
        firestationRepository.deleteFirestationList("4 le village");
        verify(database).getFirestations();
        List<Firestation> findFirestationAllResult = firestationRepository.findFirestationAll();

        //THEN
        assertSame(firestationList, findFirestationAllResult);
        assertTrue(findFirestationAllResult.isEmpty());
    }

    @Test
    @DisplayName("Test findByIdTest")
    public void findByIdTest() {
        //GIVEN
        List<Firestation> firestationList = new ArrayList<Firestation>();
        Firestation            firestation     = new Firestation("4 le village", 7, new ArrayList<Person>());
        firestationList.add(firestation);

        //WHEN
        when(database.getFirestations()).thenReturn(firestationList);
        assertSame(firestation, firestationRepository.findById("4 le village"));
        verify(database).getFirestations();

        //THEN
        assertSame(firestationList, firestationRepository.findFirestationAll());
    }

    @Test
    @DisplayName("Test findAddressByStationTest")
    public void findAddressByStationTest() {
        //GIVEN
        List<Firestation> firestationList = new ArrayList<Firestation>();

        //WHEN
        when(database.getFirestations()).thenReturn(firestationList);
        assertTrue(firestationRepository.findAddressByStation(10).isEmpty());
        verify(database).getFirestations();

        //THEN
        assertSame(firestationList, firestationRepository.findFirestationAll());
    }


}


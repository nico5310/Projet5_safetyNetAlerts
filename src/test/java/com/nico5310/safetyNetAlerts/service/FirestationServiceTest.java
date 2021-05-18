package com.nico5310.safetyNetAlerts.service;
import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.repository.FirestationRepository;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class FirestationServiceTest {

    @Mock
    private FirestationService firestationService;

    @InjectMocks
    private FirestationRepository firestationRepository;

    @Test
    @DisplayName("Test findFirestationAll with new Address and number station")
    public void findFirestationAll() {
        //GIVEN
        Firestation firestation = new Firestation();
        firestation.setAddress("4 le village");
        firestation.setStation(7);
        List<Firestation> firestationList = new ArrayList<Firestation>();
        firestationList.add(firestation);

        //WHEN
        when(firestationService.findFirestationAll()).thenReturn(firestationList);

        //THEN
        assertThat(firestationService.findFirestationAll().toString(),containsString("4 le village"));
    }

    @Test
    @DisplayName("Test saveFirestationList with new Address and number station")
    public void saveFirestationList() {
        //GIVEN
        Firestation firestation = new Firestation();
        firestation.setAddress("4 le village");
        firestation.setStation(7);
        List<Firestation> firestationList = new ArrayList<Firestation>();
        firestationList.add(firestation);

        //WHEN
        when(firestationService.saveFirestationList(firestation)).thenReturn(firestationList);

        //THEN
        assertThat(firestationService.saveFirestationList(firestation).toString(), containsString("4 le village"));
    }

    @Test
    @DisplayName("Test updatePersonList with an exist station")
    public void updatePersonList() {
        //GIVEN
        Firestation firestation = new Firestation();
        firestation.setAddress("4 le village");
        firestation.setStation(7);

        //WHEN
        when(firestationService.updateFirestationList(firestation)).thenReturn(firestation);

        //THEN
        assertThat(firestationService.updateFirestationList(firestation).toString(), containsString("4 le village"));

    }

    @Test
    @DisplayName("Test deleteFirestationList with an address")
    public void deleteFirestationList() {
        //GIVEN
        Firestation firestation = new Firestation();
        firestation.setAddress("4 le village");
        firestation.setStation(7);
        firestationService.saveFirestationList(firestation);

        //WHEN
        firestationService.deleteFirestationList("4 le village");

        //THEN
        assertThat(firestationService.findFirestationAll().toString(), containsString(""));

    }

    @Test
    @DisplayName("Test findById")
    public void findById() {
        //GIVEN
        Firestation firestation = new Firestation();
        firestation.setAddress("4 le village");
        firestation.setStation(7);
        firestationService.saveFirestationList(firestation);

        //WHEN
        when(firestationService.findById("4 le village")).thenReturn(firestation);

        //THEN
        assertThat(firestationService.findById("4 le village").toString(), containsString("4 le village"));

    }

    @Test
    @DisplayName("Test findAddressByStation")
    public void findAddressByStation() {
        //GIVEN
        Firestation firestation = new Firestation();
        firestation.setAddress("4 le village");
        firestation.setStation(7);
        List<Firestation> firestationList = new ArrayList<Firestation>();
        firestationList.add(firestation);

        //WHEN
        when(firestationService.findAddressByStation(7)).thenReturn(firestationList);

        //THEN
        assertThat(firestationService.findAddressByStation(7).toString(), containsString("7"));

    }
}

package com.nico5310.safetyNetAlerts.controller;

import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.service.FirestationService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(FirestationController.class)
public class FirestationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FirestationService firestationService;

    @Test
    @DisplayName("Test return status for findFirestationALl request")
    public void findFirestationAll() throws Exception {
        //GIVEN
        Firestation firestation = new Firestation(); // create new object Firestation
        firestation.setAddress("4 le village"); // set address to object
        firestation.setStation(7); // set stationNumber to Firestation
        List<Firestation> firestationList = new ArrayList<>();  // create new List of Firestation
        firestationList.add(firestation); // add object Firestation to list of Firestation
        when(firestationService.findFirestationAll()).thenReturn(firestationList); // when the service is called, return new List
        //WHEN

        mockMvc.perform(get("/firestations")).andExpect(status().isOk()); // Execute request with Get"firestations" and wait for an answer 200 status

        // THEN

        verify(firestationService, times(1)).findFirestationAll(); // verify when service firestationService is called one more times

    }

    @Test
    @DisplayName("Test return status for saveFirestationList request")
    public void saveFirestationList() throws Exception {
        //GIVEN
        Firestation firestation = new Firestation();
        firestation.setAddress("4 le village");
        firestation.setStation(7);
        List<Firestation> firestationList = new ArrayList<>();
        when(firestationService.saveFirestationList(any(Firestation.class))).thenReturn(firestationList);

        //WHEN
        mockMvc.perform(post("/firestation").content("{ \"address\":\"4 le village\", \"station\":\"7\" }").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        //THEN
        verify(firestationService, times(1)).saveFirestationList(any(Firestation.class));


    }

    @Test
    @DisplayName("Test return status for updateFirestationList request")
    public void updateFirestationList() throws Exception {
        //GIVEN
        Firestation firestation = new Firestation();
        firestation.setAddress("4 le village");
        firestation.setStation(7);
        when(firestationService.updateFirestationList(any(Firestation.class))).thenReturn(firestation);

        //WHEN
        mockMvc.perform(put("/firestation").content("{ \"address\":\"4 le village\", \"station\":\"7\" }").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        //THEN
        verify(firestationService, times(1)).updateFirestationList(any(Firestation.class));

    }

    @Test
    @DisplayName("Test return status for deleteFirestationList request")
    public void deleteFirestationList() throws Exception {
        //GIVEN

        //WHEN
        mockMvc.perform(delete("/firestation")).andExpect(status().isOk());

        //THEN
        verify(firestationService, times(1)).deleteFirestationList(any(String.class));

    }



}

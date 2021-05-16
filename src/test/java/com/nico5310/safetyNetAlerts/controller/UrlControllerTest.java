package com.nico5310.safetyNetAlerts.controller;

import com.nico5310.safetyNetAlerts.service.UrlEndpointService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    UrlEndpointService urlEndpointService;

 //    @Test
//    @DisplayName("Test return status for allPersonsByStation request")
//    public void allPersonsByStation() throws Exception {
//
//        //GIVEN
//        List<Person> listPersonsList = new ArrayList<>(); // Create new list of Person of object PersonsByStationDto
//        long children = 0; // initialize parameters children = 0
//        long adults = 0; // initialize parameters adults = 0
//        PersonsByStationDto personsByStationDto = new PersonsByStationDto(listPersonsList, children, adults); // Initialize new Object personsByStationDto with parameters
//        when(urlEndpointService.allPersonsByStation(any(int.class))).thenReturn(personsByStationDto);// when the service is called, return new List
//
//        //WHEN
//        this.mockMvc.perform(get("/firestation?stationNumber=0")).andExpect(status().isOk()); //Execute request with Get"person" and wait for an answer 200 status with "key" stationNumber and "value" 7
//
//        //THEN
//        verify(urlEndpointService, times(1)).allPersonsByStation(any(int.class));
//    }

    @Test
    public void listPersonsByStationWithExistStationTest() throws Exception {
        mockMvc.perform(get("/firestation?stationNumber=3")).andExpect(status().isOk());
    }

    @Test
    public void listPersonsByStationWithDontExistStationTest() throws Exception {
        mockMvc.perform(get("/firestation?stationNumber=7")).andExpect(status().isOk());
    }

    @Test
    public void listPersonsByStationWithNoneStationTest() throws Exception {
        mockMvc.perform(get("/firestation?stationNumber= ")).andExpect(status().isBadRequest());
    }
    @Test
    @DisplayName("Test avec une adresse qui n'existe pas")
    public void listChildByAdressWithAddressNotExistTest() throws Exception {
        mockMvc.perform(get("/childAlert?address=99 Street Ct")).andExpect(status().isOk());
    }









}

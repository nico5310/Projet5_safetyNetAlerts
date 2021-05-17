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


    // URL 1 Test
    @Test
    @DisplayName("Test return status 200 for valid stationNumber -> request")
    public void allPersonsByStationTest() throws Exception {
        mockMvc.perform(get("/firestation?stationNumber=3")).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test return status 200 for null stationNumber -> badRequest")
    public void allPersonsByStationNullStationTest() throws Exception {
        mockMvc.perform(get("/firestation?stationNumber=")).andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Test return status 200 for invalid String stationNumber -> badRequest")
    public void allPersonsByStationErrorStationTest() throws Exception {
        mockMvc.perform(get("/firestation?stationNumber=test ")).andExpect(status().isBadRequest());
    }

    // URL 2 Test
    @Test
    @DisplayName("Test return status 200 for valid address -> request")
    public void allChildByAddressTest() throws Exception {
        mockMvc.perform(get("/childAlert?address=1509 Culver St")).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test return status 200 for invalid address => request")
    public void allChildByAddressNullTest() throws Exception {
        mockMvc.perform(get("/childAlert?address=")).andExpect(status().isOk());
    }

    // URL 3 Test
    @Test
    @DisplayName("Test return status 200 for valid firestation number => request")
    public void allPhoneByFirestationTest() throws Exception {
        mockMvc.perform(get("/phoneAlert?firestation=2")).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test return status 200 for invalid firestation number => request")
    public void allPhoneByFirestationErrorTest() throws Exception {
        mockMvc.perform(get("/phoneAlert?firestation=aze")).andExpect(status().isBadRequest());
    }

    // URL 4 Test
    @Test
    @DisplayName("Test return status 200 for valid address firestation => request")
    public void allPersonsByAddressTest() throws Exception {
        mockMvc.perform(get("/fire?address=892 Downing Ct")).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test return status 200 noFound address firestation => request")
    public void allPersonsByAddressNoFoundTest() throws Exception {
        mockMvc.perform(get("/fire?address=")).andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Test return status 200 error address firestation => request")
    public void allPersonsByAddressErrorTest() throws Exception {
        mockMvc.perform(get("/fire?address=village")).andExpect(status().isNotFound());
    }

    // URL 5 Test
    @Test
    @DisplayName("Test return status 200 for valid number firestation => request")
    public void allFamilyByStationTest() throws Exception {
        mockMvc.perform(get("/flood/stations?stations=4")).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test return status 200 for not number firestation => request")
    public void allFamilyByStationDontExistTest() throws Exception {
        mockMvc.perform(get("/flood/stations?stations=")).andExpect(status().isOk());
    }

    // URL 6 Test
    @Test
    @DisplayName("Test return status 200 for valid firstName and lastname personInfo => request")
    public void allPersonInfoTest() throws Exception {
        mockMvc.perform(get("/personInfo?firstName=John&lastName=Boyd")).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test return status 200 for no firstName and lastname personInfo => request")
    public void allPersonInfoNotExistTest() throws Exception {
        mockMvc.perform(get("/personInfo?firstName=&lastname")).andExpect(status().isBadRequest());
    }

    // URL  Test
    @Test
    @DisplayName("Test return status 200 for valid firstName and lastname personInfo => request")
    public void allEmailsByCityTest() throws Exception {
        mockMvc.perform(get("/communityEmail?city=Culver")).andExpect(status().isOk());
    }


}

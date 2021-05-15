package com.nico5310.safetyNetAlerts.controller;

import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.service.MedicalrecordService;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(MedicalrecordController.class)
public class MedicalrecordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MedicalrecordService medicalrecordService;

    @Test
    @DisplayName("Test return status for findFirestationALl request")
    public void findMedicalrecordAll() throws Exception {
        //GIVEN
        Medicalrecord medicalrecord = new Medicalrecord(); // create new object Firestation
        List<String>  medications   = new ArrayList<String>(); // create new medications List
        medications.add("kestin"); // add medications to List medications
        medications.add("doliprane"); // add medications to List medications
        List<String> allergies = new LinkedList<String>(); // create new allergies List
        allergies.add("gramines"); // // add allergies to List allergies
        allergies.add("pollen"); // add allergies to List allergies
        List<Medicalrecord> medicalrecordList = new ArrayList<Medicalrecord>();  // create new List of MedicalRecord
        medicalrecord.setFirstName("nicolas"); // add parameters to List
        medicalrecord.setLastName("biancucci"); // add parameters to List
        medicalrecord.setBirthdate("10/07/1980"); // add parameters to List
        medicalrecord.setMedications(medications); // add parameters to List
        medicalrecord.setAllergies(allergies); // add parameters to List
        medicalrecordList.add(medicalrecord); // add object Firestation to list of Firestation
        when(medicalrecordService.findMedicalrecordAll()).thenReturn(medicalrecordList); // when the service is called, return new List

        //WHEN
        mockMvc.perform(get("/medicalRecord"))
               .andExpect(status().isOk()); // Execute request with Get"medicalrecord" and wait for an answer 200 status

        // THEN
        //        assertEquals(status, 200); // Verify when status return is equals 200 valid request
        verify(medicalrecordService, times(1)).findMedicalrecordAll(); // verify when service firestationService is called one more times

    }

    @Test
    @DisplayName("Test return status for saveMedicalrecordList request")
    public void saveMedicalrecordList() throws Exception {
        //GIVEN
        Medicalrecord       medicalrecord     = new Medicalrecord();
        List<Medicalrecord> medicalrecordList = new ArrayList<Medicalrecord>();

        when(medicalrecordService.saveMedicalrecordList(any(Medicalrecord.class))).thenReturn(medicalrecordList);

        //WHEN
        mockMvc.perform(post("/medicalRecord").content("{ \"firstName\":\"nicolas\", \"lastName\":\"biancucci\", \"birthdate\":\"10/07/1980\", \"medications\":[\"kestin: 10mg\", \"doliprane:1000mg\"], \"allergies\":[\"gramines\", \"pollen\"] }")
                                              .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        //THEN
        verify(medicalrecordService, times(1)).saveMedicalrecordList(any(Medicalrecord.class));


    }

    @Test
    @DisplayName("Test return status for updateMedicalrecordList request")
    public void updateMedicalrecordList() throws Exception {
        //GIVEN
        Medicalrecord medicalrecord = new Medicalrecord();
        List<String>  medications   = new ArrayList<String>();
        medications.add("kes");
        medications.add("doli");
        List<String> allergies = new ArrayList<String>();
        allergies.add("gram");
        allergies.add("poll");
        medicalrecord.setFirstName("nicolas");
        medicalrecord.setLastName("biancucci");
        medicalrecord.setBirthdate("10/07/1980");
        medicalrecord.setAllergies(allergies);
        medicalrecord.setMedications(medications);
        when(medicalrecordService.updateMedicalrecordList(any(String.class), (any(Medicalrecord.class)))).thenReturn(medicalrecord);

        //WHEN
        mockMvc.perform(put("/medicalRecord/nicolasbiancucci").content("{\"firstName\":\"nicolas\"}")
                                                              .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk());

        //THEN
        verify(medicalrecordService, times(1)).updateMedicalrecordList(any(String.class), (any(Medicalrecord.class)));

    }

    //    @Test
    //    @DisplayName("Test return status for deleteMedicalrecordList request")
    //    public void deleteMedicalrecordList() throws Exception {
    //        //GIVEN
    //        Mockito.doNothing().when(medicalrecordService).deleteMedicalrecordList("firstNameAndLastName");
    //
    //        //WHEN
    //       mockMvc.perform(delete("/medicalRecord/nicolasbiancucci")).andExpect(status().isOk());
    //
    //        //THEN
    //        verify(medicalrecordService, times(1)).deleteMedicalrecordList(any(String.class));
    //
    //    }
}

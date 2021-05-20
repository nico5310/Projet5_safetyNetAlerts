package com.nico5310.safetyNetAlerts.service;


import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.repository.MedicalrecordRepositoryInterface;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class MedicalrecordServiceTest {

    private MedicalrecordService medicalrecordService;

    @Mock
    private MedicalrecordRepositoryInterface medicalrecordRepositoryInterface;


    @Before
    public void setUp() throws Exception {
        medicalrecordService = new MedicalrecordService(medicalrecordRepositoryInterface);
    }

    @Test
    @DisplayName("Test findMedicalrecordAll")
    public void findMedicalrecordAll() {
        //GIVEN
        Medicalrecord       medicalrecord = new Medicalrecord();
        List<String>        medications   = new ArrayList<>();
        medications.add("kestin");
        medications.add("doliprane");
        List<String> allergies = new LinkedList<>();
        allergies.add("gramines");
        allergies.add("pollen");
        List<Medicalrecord> medicalrecordList = new ArrayList<>();
        medicalrecord.setFirstName("nicolas");
        medicalrecord.setLastName("biancucci");
        medicalrecord.setBirthdate("10/07/1980");
        medicalrecord.setMedications(medications);
        medicalrecord.setAllergies(allergies);
        medicalrecordList.add(medicalrecord);

        //WHEN
        when(medicalrecordRepositoryInterface.findMedicalrecordAll()).thenReturn(medicalrecordList);

        //THEN
        assertThat(medicalrecordService.findMedicalrecordAll().toString(), containsString("nicolas"));

    }

    @Test
    @DisplayName("Test saveMedicalrecordList ")
    public void saveMedicalrecordList() {
        //GIVEN
        Medicalrecord medicalrecord = new Medicalrecord();
        List<String>  medications   = new ArrayList<String>();
        medications.add("kestin");
        medications.add("doliprane");
        List<String> allergies = new ArrayList<String>();
        allergies.add("gramines");
        allergies.add("pollen");
        List<Medicalrecord> medicalrecordList = new ArrayList<Medicalrecord>();
        medicalrecord.setFirstName("nicolas");
        medicalrecord.setLastName("biancucci");
        medicalrecord.setBirthdate("10/07/1980");
        medicalrecord.setMedications(medications);
        medicalrecord.setAllergies(allergies);
        medicalrecordList.add(medicalrecord);

        //WHEN
        when(medicalrecordRepositoryInterface.saveMedicalrecordList(medicalrecord)).thenReturn(medicalrecordList);

        //THEN
        assertThat(medicalrecordService.saveMedicalrecordList(medicalrecord).toString(), containsString("nicolas"));

    }

    @Test
    @DisplayName("Test deletePersonList")
    public void deletePersonList() {
        //GIVEN
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
        medicalrecordService.saveMedicalrecordList(medicalrecord);

        //WHEN
        medicalrecordRepositoryInterface.deleteMedicalrecordList("nicolasbiancucci");

        //THEN
        assertThat(medicalrecordService.findMedicalrecordAll().toString(), containsString(""));

    }

    @Test
    @DisplayName("Test findByFirstName")
    public void findByFirstName() {
        //GIVEN
        Medicalrecord medicalrecord = new Medicalrecord();
        List<String>  medications   = new ArrayList<String>();
        medications.add("kestin");
        medications.add("doliprane");
        List<String> allergies = new LinkedList<String>();
        allergies.add("gramines");
        allergies.add("pollen");
        medicalrecord.setFirstName("nicolas");
        medicalrecord.setLastName("biancucci");
        medicalrecord.setBirthdate("10/07/1980");
        medicalrecord.setMedications(medications);
        medicalrecord.setAllergies(allergies);

        //WHEN
        when(medicalrecordRepositoryInterface.findByFirstName("nicolas")).thenReturn(medicalrecord);

        //THEN
        assertThat(medicalrecordRepositoryInterface.findByFirstName("nicolas").toString(), containsString("nicolas"));

    }

    @Test
    @DisplayName("Test findByFirstNameAndLastName")
    public void findByFirstNameAndLastName() {
        //GIVEN
        Medicalrecord medicalrecord = new Medicalrecord();
        List<String>  medications   = new ArrayList<String>();
        medications.add("kestin");
        medications.add("doliprane");
        List<String> allergies = new LinkedList<String>();
        allergies.add("gramines");
        allergies.add("pollen");
        medicalrecord.setFirstName("nicolas");
        medicalrecord.setLastName("biancucci");
        medicalrecord.setBirthdate("10/07/1980");
        medicalrecord.setMedications(medications);
        medicalrecord.setAllergies(allergies);

        //WHEN
        when(medicalrecordRepositoryInterface.findByFirstNameAndLastName("nicolas", "biancucci")).thenReturn(medicalrecord);

        //THEN
        assertThat(medicalrecordService.findByFirstNameAndLastName("nicolas", "biancucci")
                                       .toString(), containsString("biancucci"));

    }

}

package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.repository.MedicalrecordRepository;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MedicalrecordServiceTest {

    @Mock
    MedicalrecordService medicalrecordService;

    @InjectMocks
    MedicalrecordRepository medicalrecordRepository;

    @Test
    @DisplayName("Test findMedicalrecordAll")
    public void findMedicalrecordAll() {
        //GIVEN
        Medicalrecord medicalrecord = new Medicalrecord();
        List<String>  medications   = new ArrayList<String>();
        medications.add("kestin");
        medications.add("doliprane");
        List<String> allergies = new LinkedList<String>();
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
        when(medicalrecordService.findMedicalrecordAll()).thenReturn(medicalrecordList);

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
        List<String> allergies = new LinkedList<String>();
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
        when(medicalrecordService.saveMedicalrecordList(medicalrecord)).thenReturn(medicalrecordList);

        //THEN
        assertThat(medicalrecordService.saveMedicalrecordList(medicalrecord).toString(), containsString("nicolas"));

    }

    @Test
    @DisplayName("Test updateMedicalrecordList")
    public void updateMedicalrecordList() {
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
        when(medicalrecordService.updateMedicalrecordList("nicolasbiancucci", medicalrecord)).thenReturn(medicalrecord);

        //THEN
        assertThat(medicalrecordService.updateMedicalrecordList("nicolasbiancucci", medicalrecord)
                                       .toString(), containsString("nicolas"));

    }

    @Test
    @DisplayName("Test deletePersonList")
    public void deletePersonList () {
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
        medicalrecordService.saveMedicalrecordList(medicalrecord);

        //WHEN
        medicalrecordService.deleteMedicalrecordList("nicolasbiancucci");

        //THEN
        assertThat(medicalrecordService.findMedicalrecordAll().toString(), containsString(""));

    }

}

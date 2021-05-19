package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Database;
import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.repository.MedicalrecordRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class MedicalrecordServiceTest {

     MedicalrecordService medicalrecordService;



    @Mock
    Database database;
    @Mock
    MedicalrecordRepository medicalrecordRepository;

    public List<Medicalrecord> medicalrecords = new ArrayList<>();

    Medicalrecord medicalrecord;
    List<String> medications = null;
    List<String> allergies = null;
    String birthdate = null;
    Medicalrecord   medicalrecordObject1 = new Medicalrecord("##", "lastName", birthdate, medications, allergies);
    Medicalrecord   medicalrecordObject2 =  new Medicalrecord("firstName", "**", birthdate, medications, allergies);

//    @BeforeAll
//    public void setUp() {
//
//        //        database = mock(Database.class);
//        //        medicalrecordRepositoryInterface = mock(MedicalrecordRepository.class);
//        medicalrecordService = new MedicalrecordService(medicalrecordRepositoryInterface);
//
//    }

    @BeforeEach
    private void setUp() throws ParseException {
        medicalrecord = new Medicalrecord("firstName", "lastName", birthdate, medications, allergies);

    }

    @Test
    public void findMedicalrecordAllTest() throws Exception {
        medicalrecords.add(new Medicalrecord("nicolas", "biancucci", birthdate, medications, allergies));
        medicalrecords.add(new Medicalrecord("zorro", "biancucci", birthdate, medications, allergies));
        medicalrecords.add(new Medicalrecord("tintin", "dupont", birthdate, medications, allergies));

        when(medicalrecordRepository.findMedicalrecordAll()).thenReturn(medicalrecords);

        assertThat(medicalrecordService.findMedicalrecordAll().size()).isEqualTo(3);
    }

//    @Test
//    public void saveMedicalrecordListTest() throws Exception{
//        when(medicalrecordRepository.)
//
//
//    }



    //    @Test
//    @DisplayName("Test findMedicalrecordAll")
//    public void findMedicalrecordAll() {
//        //GIVEN
//        Medicalrecord medicalrecord = new Medicalrecord();
//        List<String>  medications   = new ArrayList<>();
//        medications.add("kestin");
//        medications.add("doliprane");
//        List<String> allergies = new LinkedList<>();
//        allergies.add("gramines");
//        allergies.add("pollen");
//        List<Medicalrecord> medicalrecordList = new ArrayList<>();
//        medicalrecord.setFirstName("nicolas");
//        medicalrecord.setLastName("biancucci");
//        medicalrecord.setBirthdate("10/07/1980");
//        medicalrecord.setMedications(medications);
//        medicalrecord.setAllergies(allergies);
//        medicalrecordList.add(medicalrecord);
//
//        //WHEN
//        when(database.getMedicalrecords()).thenReturn(medicalrecordList);
//        when(medicalrecordRepositoryInterface.findMedicalrecordAll()).thenReturn(medicalrecordList);
//
//        //THEN
//        assertThat(medicalrecordService.findMedicalrecordAll().toString(), containsString("nicolas"));
//
//    }

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
        when(medicalrecordService.saveMedicalrecordList(medicalrecord)).thenReturn(medicalrecordList);

        //THEN
        assertThat(medicalrecordService.saveMedicalrecordList(medicalrecord).toString(), containsString("nicolas"));

    }

//    @Test
//    @DisplayName("Test updateMedicalrecordList")
//    public void updateMedicalrecordList() {
//        //GIVEN
//        Medicalrecord medicalrecord = new Medicalrecord();
//        List<String>  medications   = new ArrayList<String>();
//        medications.add("kestin");
//        medications.add("doliprane");
//        List<String> allergies = new ArrayList<String>();
//        allergies.add("gramines");
//        allergies.add("pollen");
//        medicalrecord.setFirstName("nicolas");
//        medicalrecord.setLastName("biancucci");
//        medicalrecord.setBirthdate("10/07/1980");
//        medicalrecord.setMedications(medications);
//        medicalrecord.setAllergies(allergies);
//
//        //WHEN
//        when(medicalrecordService.updateMedicalrecordList("nicolasbiancucci", medicalrecord)).thenReturn(medicalrecord);
//
//        //THEN
//        assertThat(medicalrecordService.updateMedicalrecordList("nicolasbiancucci", medicalrecord)
//                                       .toString(), containsString("nicolas"));
//
//    }

    @Test
    @DisplayName("Test deletePersonList")
    public void deletePersonList () {
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
        medicalrecordService.deleteMedicalrecordList("nicolasbiancucci");

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
        when(medicalrecordService.findByFirstName("nicolas")).thenReturn(medicalrecord);

        //THEN
        assertThat(medicalrecordService.findByFirstName("nicolas").toString(), containsString("nicolas"));

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
        when(medicalrecordService.findByFirstNameAndLastName("nicolas","biancucci")).thenReturn(medicalrecord);

        //THEN
        assertThat(medicalrecordService.findByFirstNameAndLastName("nicolas","biancucci").toString(), containsString("biancucci"));

    }

}

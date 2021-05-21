package com.nico5310.safetyNetAlerts.controller;

import com.nico5310.safetyNetAlerts.model.Database;
import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.repository.MedicalrecordRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MedicalrecordRepositoryTest {

    @Mock
    private Database database;

    @InjectMocks
    private MedicalrecordRepository medicalrecordRepository;

    @Test
    @DisplayName("Test FindMedicalRecordAll")
    public void findMedicalrecordAllTest() {
        //GIVEN
        List<Medicalrecord> medicalrecordList = new ArrayList<Medicalrecord>();

        //WHEN
        when(database.getMedicalrecords()).thenReturn(medicalrecordList);
        List<Medicalrecord> findMedicalrecordAll = medicalrecordRepository.findMedicalrecordAll();

        //THEN
        assertSame(medicalrecordList, findMedicalrecordAll);
        assertTrue(findMedicalrecordAll.isEmpty());
        verify(database).getMedicalrecords();
    }

    @Test
    @DisplayName("Test saveMedicalrecord")
    public void saveMedicalrecordListTest() {
        //GIVEN
        List<Medicalrecord> medicalrecordList = new ArrayList<Medicalrecord>();

        //WHEN
        when(database.getMedicalrecords()).thenReturn(medicalrecordList);
        List<Medicalrecord> saveMedicalrecordListResult = medicalrecordRepository.saveMedicalrecordList(new Medicalrecord());
        assertSame(medicalrecordList, saveMedicalrecordListResult);
        assertEquals(1, saveMedicalrecordListResult.size());

        //THEN
        verify(database).getMedicalrecords();
        assertSame(saveMedicalrecordListResult, medicalrecordRepository.findMedicalrecordAll());
    }

    @Test
    @DisplayName("Test UpdateMedicalRecordList")
    public void updateMedicalrecordListTest() throws ParseException {
        //GIVEN
        List<Medicalrecord> medicalrecordList = new ArrayList<Medicalrecord>();

        //WHEN
        when(database.getMedicalrecords()).thenReturn(medicalrecordList);
        assertNull(medicalrecordRepository.updateMedicalrecordList("Nicolas", new Medicalrecord()));

        //THEN
        verify(database).getMedicalrecords();
        assertSame(medicalrecordList,medicalrecordRepository.findMedicalrecordAll());
    }

    @Test
    @DisplayName("Test DeleteMEdicalrecordList")
    public void deleteMedicalrecordListTest() {
        //GIVEN
        List<Medicalrecord> medicalrecordList = new ArrayList<Medicalrecord>();

        //WHEN
        when(database.getMedicalrecords()).thenReturn(medicalrecordList);
        medicalrecordRepository.deleteMedicalrecordList("Nicolas");
        verify(database).getMedicalrecords();
        List<Medicalrecord> findMedicalrecordAll = medicalrecordRepository.findMedicalrecordAll();
        assertSame(medicalrecordList, findMedicalrecordAll);
        assertTrue(findMedicalrecordAll.isEmpty());
    }


    @Test
    @DisplayName("Test FindByFirstName")
    public void findByFirstNameTest() {
        //GIVEN
        List<Medicalrecord> medicalrecordList = new ArrayList<Medicalrecord>();

        //WHEN
        when(database.getMedicalrecords()).thenReturn(medicalrecordList);
        assertNull(medicalrecordRepository.findByFirstName("Nicolas"));

        //THGEN
        verify(database).getMedicalrecords();
        assertSame(medicalrecordList, medicalrecordRepository.findMedicalrecordAll());
    }


    @Test
    @DisplayName("Test FindByFirstNameAndLAstName")
    public void findByFirstNameAndLastNameTest() {
        //GIVEN
        List<Medicalrecord> medicalrecordList = new ArrayList<Medicalrecord>();

        //WHEN
        when(database.getMedicalrecords()).thenReturn(medicalrecordList);
        assertNull(medicalrecordRepository.findByFirstNameAndLastName("Nicolas", "Biancucci"));

        //THEN
        verify(database).getMedicalrecords();
        assertSame(medicalrecordList, medicalrecordRepository.findMedicalrecordAll());
    }


}


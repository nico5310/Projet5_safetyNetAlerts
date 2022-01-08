package com.nico5310.safetyNetAlerts.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
public class Database {

    private List<Person>        persons;
    private List<Medicalrecord> medicalrecords;
    private List<Firestation>   firestations;

    @PostConstruct
    public void initDatabase() throws IOException {

        Database database = new Database();
        byte[]   jsonData = Files.readAllBytes(Paths.get("src/main/resources/data.json"));

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            database = objectMapper.readValue(jsonData, Database.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.persons        = database.getPersons();
        this.medicalrecords = database.getMedicalrecords();
        this.firestations   = database.getFirestations();

        //        System.out.println("Database Object\n" + database);
    }

    public List<Person> getPersons() {

        return persons;
    }

    public List<Medicalrecord> getMedicalrecords() {

        return medicalrecords;
    }

    public List<Firestation> getFirestations() {

        return firestations;
    }


    @Override
    public String toString() {

        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Person=" + "\n" + getPersons() + "\n");
        stringbuilder.append("Medicalrecord=" + "\n" + getMedicalrecords() + "\n");
        stringbuilder.append("Firestation=" + "\n" + getFirestations() + "\n");

        return stringbuilder.toString();
    }
}

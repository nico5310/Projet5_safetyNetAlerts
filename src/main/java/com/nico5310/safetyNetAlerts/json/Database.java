package com.nico5310.safetyNetAlerts.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.model.Person;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Data
@Component
public class Database {

    private List<Person> persons;
    private List<Medicalrecord> medicalrecords;
    private List<Firestation> firestations;

    @PostConstruct
    public void initDatabase() throws IOException {
        byte[] jsonData = Files.readAllBytes(Paths.get("src/main/resources/data.json"));

        // create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // convert json string to object
        Database database = objectMapper.readValue(jsonData, Database.class);
        this.persons = database.getPersons();
        this.medicalrecords = database.getMedicalrecords();
        this.firestations = database.getFirestations();
        System.out.println("Database Object\n" + database);

    }


    @Override
    public String toString(){
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Person=" + "\n" + getPersons() + "\n");
        stringbuilder.append("Medicalrecord=" + "\n" + getMedicalrecords() + "\n");
        stringbuilder.append("Firestation=" + "\n" + getFirestations() + "\n");

        return stringbuilder.toString();
    }
}

package com.nico5310.safetyNetAlerts.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.model.Person;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FirestationDto {

    private String address;
    private String station;

    @JsonIgnore
    private List<Person> person = new ArrayList<>();

    /**
     * Constructor firestationDto
     */
    public FirestationDto() {

    }

    public FirestationDto (Firestation firestation) {

        this.address = firestation.getAddress();
        this.station = firestation.getStation();
        this.person = firestation.getPerson();
    }


}

package com.nico5310.safetyNetAlerts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class Firestation {

    private String address;
    private int station;
    @JsonIgnore
    private List<Person> person;

    /**
     * Constructor firestation
     */
    public Firestation() {

    }

    public Firestation(String address, int station, List<Person> person) {

        this.address = address;
        this.station = station;
        this.person  = person;
    }

    @Override
    public String toString(){
        return getAddress() + ", " + getStation() + "\n";
    }

}

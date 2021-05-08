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
    public Firestation(String address, int station) {
        this.address = address;
        this.station = station;
    }

    public Firestation() {

    }


    @Override
    public String toString(){
        return getAddress() + ", " + getStation() + "\n";
    }

}

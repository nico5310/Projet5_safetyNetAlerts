package com.nico5310.safetyNetAlerts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


import java.util.List;

@Data
public class Firestation {

    private String address;
    private String station;

    @JsonIgnore
    private List<Person> person;

    /**
     * Constructor firestation
     */
    public Firestation() {
        super();
    }

    public Firestation(String address, String station) {
        this.address = address;
        this.station = station;
    }

    public String toString(){
        return getAddress() + ", " + getStation() + "\n";
    }

}

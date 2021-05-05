package com.nico5310.safetyNetAlerts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Firestation {

    private String address;
    private String station;

    @JsonIgnore
    private List<Person> person = new ArrayList<>();

    @Override
    public String toString(){
        return getAddress() + ", " + getStation() + "\n";
    }

}

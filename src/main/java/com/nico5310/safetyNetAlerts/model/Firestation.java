package com.nico5310.safetyNetAlerts.model;

import lombok.Data;

@Data
public class Firestation {

    private String address;
    private String station;

    @Override
    public String toString(){
        return getAddress() + ", " + getStation() + "\n";
    }

}

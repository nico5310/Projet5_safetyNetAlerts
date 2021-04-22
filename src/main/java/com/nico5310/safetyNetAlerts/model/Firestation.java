package com.nico5310.safetyNetAlerts.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "firestations")
public class Firestation {

    @Id
    @GeneratedValue
    private Long id;

    private String address;
    private String station;

    @Override
    public String toString(){
        return getAddress() + ", " + getStation() + "\n";
    }

}

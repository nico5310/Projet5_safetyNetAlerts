package com.nico5310.safetyNetAlerts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Firestation {

    private String       address;
    private int          station;
    @JsonIgnore
    private List<Person> person;

    public Firestation() {

    }

    public Firestation(String address, int station, List<Person> person) {
        this.address = address;
        this.station = station;
        this.person  = person;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStation() {
        return station;
    }

    public void setStation(int station) {
        this.station = station;
    }

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return getAddress() + ", " + getStation() + "\n";
    }

}

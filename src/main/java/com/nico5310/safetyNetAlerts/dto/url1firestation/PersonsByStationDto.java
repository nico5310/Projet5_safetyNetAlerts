package com.nico5310.safetyNetAlerts.dto.url1firestation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nico5310.safetyNetAlerts.model.Person;

import java.util.List;

public class PersonsByStationDto {

    @JsonIgnoreProperties({"zip", "city", "email"})
    private List<Person> listPersonsStation;
    private long         adults;
    private long         children;

    public PersonsByStationDto(List<Person> listPersonsStation, long adults, long children) {

        this.listPersonsStation = listPersonsStation;
        this.adults             = adults;
        this.children           = children;
    }

    public PersonsByStationDto() {


    }

    public List<Person> getListPersonsStation() {

        return listPersonsStation;
    }


    @Override
    public String toString() {

        return " [ PersonsByFirestation=" + listPersonsStation.toString() + " adults=" + adults + ", children=" + children + "]";
    }

}

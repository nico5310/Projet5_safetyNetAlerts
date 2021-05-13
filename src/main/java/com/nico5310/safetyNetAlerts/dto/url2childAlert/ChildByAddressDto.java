package com.nico5310.safetyNetAlerts.dto.url2childAlert;

import lombok.Data;

import java.util.List;

@Data
public class ChildByAddressDto {

    private List<PersonsWithAge> children;
    private List<PersonsWithAge> adults;


    public List<PersonsWithAge> getChildren() {

        return children;
    }

    public void setChildren(List<PersonsWithAge> children) {

        this.children = children;
    }

    public List<PersonsWithAge> getAdults() {

        return adults;
    }

    public void setAdults(List<PersonsWithAge> adults) {

        this.adults = adults;
    }

    @Override
    public String toString(){
        return "ChildByAddressDto [children=" + getChildren() + ", adults=" + getAdults() + "]" ;
    }
}

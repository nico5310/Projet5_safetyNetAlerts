package com.nico5310.safetyNetAlerts.dto.url2childAlert;

import lombok.Data;

import java.util.List;

@Data
public class ChildByAddress {

    private String address;
    private List<AgeOfPerson> adults;
    private List<AgeOfPerson> children;

    @Override
    public String toString() {
        return "ChildByAddress [" + getAddress() + ", " + getAdults() + ", " + getChildren() + "]";
    }

}

package com.nico5310.safetyNetAlerts.dto.url6personInfo;

import lombok.Data;

import java.util.List;

@Data
public class PersonInfo {

    private List<PersonInfoList> personInfoLists;

    @Override
    public String toString() {
        return "PersonInfo [" + getPersonInfoLists() + "]";
    }

}

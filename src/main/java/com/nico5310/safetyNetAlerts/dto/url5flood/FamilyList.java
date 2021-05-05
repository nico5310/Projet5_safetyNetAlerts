package com.nico5310.safetyNetAlerts.dto.url5flood;

import com.nico5310.safetyNetAlerts.dto.urlData.PersonFireFloodList;
import lombok.Data;

import java.util.List;

@Data
public class FamilyList {

    private String  address;
    private List<PersonFireFloodList> personFireFloodLists;

    @Override
    public String toString() {
        return "Flood [" + getAddress() + ", " + getPersonFireFloodLists() + "]";
    }

}

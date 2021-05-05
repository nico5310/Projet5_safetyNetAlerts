package com.nico5310.safetyNetAlerts.dto.url4fire;

import com.nico5310.safetyNetAlerts.dto.urlData.PersonFireFloodList;
import lombok.Data;

import java.util.List;

@Data
public class Fire {

    private String fireStationNumber;
    private String                    address;
    private List<PersonFireFloodList> personFireFloodList;

    @Override
    public String toString() {
        return "Fire [" + getFireStationNumber() + ", " + getAddress() + ", " + getPersonFireFloodList() + "]";
    }
}

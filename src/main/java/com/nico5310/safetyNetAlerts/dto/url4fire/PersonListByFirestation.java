package com.nico5310.safetyNetAlerts.dto.url4fire;

import com.nico5310.safetyNetAlerts.dto.urlData.PersonFireFloodListDto;
import lombok.Data;

import java.util.List;

@Data
public class PersonListByFirestation {

    private String fireStationNumber;
    private String                       address;
    private List<PersonFireFloodListDto> personFireFloodList;

    @Override
    public String toString() {
        return "Fire [" + getFireStationNumber() + ", " + getAddress() + ", " + getPersonFireFloodList() + "]";
    }
}

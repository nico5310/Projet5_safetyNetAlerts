package com.nico5310.safetyNetAlerts.dto.url5flood;

import com.nico5310.safetyNetAlerts.dto.urlData.PersonFireFloodListDto;
import lombok.Data;

import java.util.List;

@Data
public class FamilyListDto {

    private String                      address;
    private List<PersonFireFloodListDto> personFireFloodListDto;

    @Override
    public String toString() {
        return "Flood [" + getAddress() + ", " + getPersonFireFloodListDto() + "]";
    }

}

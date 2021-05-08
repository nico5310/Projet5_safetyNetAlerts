package com.nico5310.safetyNetAlerts.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nico5310.safetyNetAlerts.model.Firestation;
import lombok.Data;

import java.util.List;

@Data
public class FirestationDto {

    private String address;
    private int station;

    @JsonIgnore
    private List<PersonDto> personDto;

    /**
     * Constructor firestationDto
     */
    public FirestationDto() {
        super();
    }

    public FirestationDto (Firestation firestation) {

        this.address = firestation.getAddress();
        this.station = firestation.getStation();
        this.personDto = getPersonDto();

    }


}

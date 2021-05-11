package com.nico5310.safetyNetAlerts.dto.url5flood;

import lombok.Data;

import java.util.List;

@Data
public class MedicalRecordByStationDto {

    private List<String> medications;
    private List<String> allergies;

    public MedicalRecordByStationDto(List<String> medications, List<String> allergies) {

        this.medications = medications;
        this.allergies   = allergies;
    }
}

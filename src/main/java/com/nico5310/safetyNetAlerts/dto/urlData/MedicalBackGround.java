package com.nico5310.safetyNetAlerts.dto.urlData;

import lombok.Data;

import java.util.List;

@Data
public class MedicalBackGround {

    private List<String> medications;
    private List<String> allergies;

    @Override
    public String toString() {
        return "MedicalBackGround [" + getMedications() + ", " + getAllergies() + "]";
    }
}

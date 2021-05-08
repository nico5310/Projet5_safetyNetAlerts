package com.nico5310.safetyNetAlerts.dto.urlData;

import lombok.Data;

@Data
public class PersonFireFloodListDto {

    private String lastName;
    private String phone;
    private int age;
    private MedicalBackGroundDto medicalBackGroundDto;

    @Override
    public String toString() {
        return "PersonFireList [" + getLastName() + ", " + getPhone() + ", " + getAge() + ", " + getMedicalBackGroundDto() + "]";
    }

}

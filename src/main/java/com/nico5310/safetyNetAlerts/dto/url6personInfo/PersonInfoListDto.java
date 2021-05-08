package com.nico5310.safetyNetAlerts.dto.url6personInfo;

import com.nico5310.safetyNetAlerts.dto.urlData.MedicalBackGroundDto;
import lombok.Data;

@Data
public class PersonInfoListDto {

    private String lastName;
    private String address;
    private int age;
    private String               email;
    private MedicalBackGroundDto medicalBackGroundDto;

    @Override
    public String toString() {
        return "PersonInfoList [" + getLastName() + ", " + getAddress() + ", " + getAge() + ", " + getEmail() + ", " + getMedicalBackGroundDto() + "]";
    }

}

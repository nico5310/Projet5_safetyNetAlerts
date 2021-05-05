package com.nico5310.safetyNetAlerts.dto.url6personInfo;

import com.nico5310.safetyNetAlerts.dto.urlData.MedicalBackGround;
import lombok.Data;

@Data
public class PersonInfoList {

    private String lastName;
    private String address;
    private int age;
    private String email;
    private MedicalBackGround medicalBackGround;

    @Override
    public String toString() {
        return "PersonInfoList [" + getLastName() + ", " + getAddress() + ", " + getAge() + ", " + getEmail() + ", " + getMedicalBackGround() + "]";
    }

}

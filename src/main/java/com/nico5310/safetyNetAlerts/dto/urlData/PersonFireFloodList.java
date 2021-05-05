package com.nico5310.safetyNetAlerts.dto.urlData;

import com.nico5310.safetyNetAlerts.dto.urlData.MedicalBackGround;
import lombok.Data;

@Data
public class PersonFireFloodList {

    private String lastName;
    private String phone;
    private int age;
    private MedicalBackGround medicalBackGround;

    @Override
    public String toString() {
        return "PersonFireList [" + getLastName() + ", " + getPhone() + ", " + getAge() + ", " + getMedicalBackGround() + "]";
    }

}

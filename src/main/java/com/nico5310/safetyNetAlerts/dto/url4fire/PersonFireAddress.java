package com.nico5310.safetyNetAlerts.dto.url4fire;

import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import lombok.Data;

import java.util.List;

@Data
public class PersonFireAddress {

    private String lastName;
    private String phone;
    private int age;
    private List<String> medications;
    private List<String> allergies;



        public PersonFireAddress(String lastName, String phone, int age, List<String> medications, List<String> allergies) {

        this.lastName    = lastName;
        this.phone       = phone;
        this.age         = age;
        this.medications = medications;
        this.allergies   = allergies;
    }

    public PersonFireAddress(Firestation firestation, List<PersonFireAddress> personFireAddressList) {}


    @Override
    public String toString() {
        return "PersonFireAddress [lastName=" + getLastName() + ", phone=" + getPhone()+ ", age=" + getAge() + ", medications="
               + getMedications() + ", allergies =" + getAllergies() + "]";
    }


}

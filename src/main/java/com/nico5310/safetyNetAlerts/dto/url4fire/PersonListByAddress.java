package com.nico5310.safetyNetAlerts.dto.url4fire;

import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.model.Person;
import lombok.Data;

import java.util.List;

@Data
public class PersonListByAddress {

    private Firestation             firestation;
    private List<PersonFireAddress> personFireAddress;


    @Override
    public String toString() {

        return "PersonFireAddress [firestation=" + getFirestation() + ", personFireAddress=" + getPersonFireAddress() + "]";
    }
}
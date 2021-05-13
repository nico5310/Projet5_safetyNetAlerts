package com.nico5310.safetyNetAlerts.dto.url4fire;

import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.model.Medicalrecord;
import com.nico5310.safetyNetAlerts.model.Person;
import lombok.Data;

import java.util.List;

@Data
public class PersonListByAddress {

    private Firestation             firestationNumber;
    private List<PersonFireAddress> listPersonsByAddress;

    public PersonListByAddress(Firestation firestationNumber, List<PersonFireAddress> listPersonsByAddress) {

        this.firestationNumber = firestationNumber;
        this.listPersonsByAddress = listPersonsByAddress;
    }

    @Override
    public String toString() {

        return "PersonFireAddress [firestation=" + getFirestationNumber() + ", personFireAddress=" + getListPersonsByAddress() + "]";
    }
}
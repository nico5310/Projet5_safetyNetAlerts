package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.repository.FirestationRepositoryInterface;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Bean class for Spring - Communicate with FirestationsRepository interface
@Data // Lombok annotation Getters and Setters.
public class FirestationService implements FirestationServiceInterface{

    @Autowired
    FirestationRepositoryInterface firestationRepositoryInterface;


    @Override
    public List<Firestation> findFirestationList() {
        return firestationRepositoryInterface.getFirestationList();
    }

    @Override
    public List<Firestation> saveFirestationList(Firestation firestation) {
        List<Firestation> saveFirestation = firestationRepositoryInterface.getFirestationList();
        saveFirestation.add(firestation);
        return saveFirestation;
    }

    @Override
    public Firestation updateFirestationList(Firestation firestation) {
        List<Firestation> updateFirestation = firestationRepositoryInterface.getFirestationList();
        for (Firestation update : updateFirestation) {
            if (update.getAddress().equals(firestation.getAddress()) && !update.getStation().equals(firestation.getStation())) {
                update.setAddress(firestation.getAddress());
                return update;
            }
        } return null;
    }

    @Override
    public boolean deleteFirestationList(String address) {
        List<Firestation> deleteFirestation = firestationRepositoryInterface.getFirestationList();
        return  deleteFirestation.removeIf(firestation -> firestation.getAddress().equals(address));
    }


}

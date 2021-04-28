package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.repository.FirestationRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirestationService implements FirestationServiceInterface{

    @Autowired
    FirestationRepositoryInterface firestationRepositoryInterface;


    @Override
    public List<Firestation> findFirestationAll() {
        return firestationRepositoryInterface.getFirestationAll();
    }

    @Override
    public List<Firestation> saveFirestationList(Firestation firestation) {
        List<Firestation> saveFirestation = firestationRepositoryInterface.getFirestationAll();
        saveFirestation.add(firestation);
        return saveFirestation;
    }

    @Override
    public Firestation updateFirestationList(Firestation firestation) {
        List<Firestation> updateFirestation = firestationRepositoryInterface.getFirestationAll();
        for (Firestation update : updateFirestation) {
            if (update.getAddress().equals(firestation.getAddress()) && !update.getStation().equals(firestation.getStation())) {
                update.setStation(firestation.getStation());
                return update;
            }
        } return null;
    }

    @Override
    public List<Firestation> deleteFirestationList(String address) {
        List<Firestation> deleteFirestation = firestationRepositoryInterface.getFirestationAll();
        deleteFirestation.removeIf(firestation -> firestation.getAddress().equals(address));
        return  deleteFirestation;
    }


}

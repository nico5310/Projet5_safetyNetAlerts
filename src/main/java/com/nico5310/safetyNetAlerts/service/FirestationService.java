package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.repository.FirestationRepositoryInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FirestationService implements FirestationServiceInterface{

    @Autowired
    FirestationRepositoryInterface firestationRepositoryInterface;


    @Override
    public List<Firestation> findFirestationAll() {

        try {
            return firestationRepositoryInterface.getFirestationAll();
        }catch (Exception exception) {
            log.error("Error retrieving the Firestation List");
        }
        return null; //TODO: modify return
    }

    @Override
    public List<Firestation> saveFirestationList(Firestation firestation) {

        try {
            List<Firestation> saveFirestation = firestationRepositoryInterface.getFirestationAll();
            for (Firestation saveFire : saveFirestation) {
                if (saveFire.getAddress().equals(firestation.getAddress())) {
                    return null; // TODO: modify return
                }
            }
            saveFirestation.add(firestation);
            return saveFirestation;
        }catch (Exception exception) {
            log.error("Error saving the Firestation to list");
        }
        return null; //TODO: modify return
    }

    @Override
    public Firestation updateFirestationList(Firestation firestation) {

        if (firestation != null) {
            List<Firestation> updateFirestation;
            try {
                updateFirestation = firestationRepositoryInterface.getFirestationAll();
            } catch (Exception exception) {
                log.error("Error updating the People to list" + exception.getMessage());
                return null; // TODO: modify return
            }
            for (Firestation update : updateFirestation) {
                if (update.getAddress().equals(firestation.getAddress()) && !update.getStation().equals(firestation.getStation())) {
                    update.setStation(firestation.getStation());
                    return update;
                }
            }
        }
        return null; // TODO: modify return
    }

    @Override
    public List<Firestation> deleteFirestationList(String address) {

        try {
            List<Firestation> deleteFirestation = firestationRepositoryInterface.getFirestationAll();
            deleteFirestation.removeIf(firestation -> firestation.getAddress().equals(address));
            return  deleteFirestation;
        }catch (Exception exception) {
            log.error("Error for deleting the Firestation");
        }
        return  null; // TODO: modify return
    }


}

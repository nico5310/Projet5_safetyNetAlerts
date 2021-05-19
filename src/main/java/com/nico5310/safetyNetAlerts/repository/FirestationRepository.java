package com.nico5310.safetyNetAlerts.repository;

import com.nico5310.safetyNetAlerts.model.Database;
import com.nico5310.safetyNetAlerts.model.Firestation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class FirestationRepository implements FirestationRepositoryInterface {

    @Autowired
    private Database database;

    public Database getDatabase() {
        return database;
    }

    @Override
    public List<Firestation> findFirestationAll() {

        return database.getFirestations();
    }

    @Override
    public List<Firestation> saveFirestationList(Firestation firestation) {

        List<Firestation> saveFirestation = database.getFirestations();
        saveFirestation.add(firestation);
        return saveFirestation;

    }

    @Override
    public Firestation updateFirestationList(Firestation firestation) {

        List<Firestation> updateFirestation = database.getFirestations();
        for (Firestation update : updateFirestation) {
            if (update.getAddress().equals(firestation.getAddress())) { ///
                update.setStation(firestation.getStation());
                return update;
            }
        }
        return null;
    }

    @Override
    public void deleteFirestationList(String address) {

        List<Firestation> deleteFirestation = database.getFirestations();
        deleteFirestation.removeIf(firestation -> firestation.getAddress().equals(address));

    }

    //Urls Endpoints
    @Override
    public Firestation findById(String firestationAddress) {

        for (Firestation address : database.getFirestations()) {
            if (address.getAddress().equals(firestationAddress)) {
               return address;
            }
        }
        return null;
    }

    @Override
    public List<Firestation> findAddressByStation(int stationNumber) {

        List<Firestation> listFirestation = new ArrayList<>();
        for (Firestation firestation : database.getFirestations()) {
            if (firestation.getStation() == stationNumber) {
                listFirestation.add(firestation);
            }
        }
        return listFirestation;
    }

}

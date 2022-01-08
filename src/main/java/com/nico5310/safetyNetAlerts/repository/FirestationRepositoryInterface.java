package com.nico5310.safetyNetAlerts.repository;

import com.nico5310.safetyNetAlerts.model.Firestation;

import java.util.List;

public interface FirestationRepositoryInterface {

    List<Firestation> findFirestationAll();


    List<Firestation> saveFirestationList(Firestation firestation);

    Firestation updateFirestationList(Firestation firestation);

    void deleteFirestationList(String address);

    //Urls Endpoints
    Firestation findById(String firestationAddress);

    List<Firestation> findAddressByStation(int stationNumber);
}

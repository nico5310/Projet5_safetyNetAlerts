package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Firestation;

import java.util.List;

public interface FirestationServiceInterface {

    List<Firestation> findFirestationAll();
    List<Firestation> saveFirestationList(Firestation firestation);
    Firestation updateFirestationList(Firestation firestation);
    boolean deleteFirestationList(String address);

    Firestation findById(String firestationAddress);
    List<Firestation> findAddressByStation(String station);

}

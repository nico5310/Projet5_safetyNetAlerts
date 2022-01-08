package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Firestation;

import java.util.List;

public interface FirestationServiceInterface {

    List<Firestation> findFirestationAll();

    List<Firestation> saveFirestationList(Firestation firestation);

    Firestation updateFirestationList(Firestation firestation);

    List<Firestation> deleteFirestationList(String address);

    // Urls Endpoints

    Firestation findById(String firestationAddress);

    List<Firestation> findAddressByStation(int station);

}

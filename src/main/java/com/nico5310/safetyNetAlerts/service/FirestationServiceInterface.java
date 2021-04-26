package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Firestation;

import java.util.List;

public interface FirestationServiceInterface {

    List<Firestation> findFirestationList();
    List<Firestation> saveFirestationList(Firestation firestation);
    Firestation updateFirestationList(Firestation firestation);
    boolean deleteFirestationList(String address);
}

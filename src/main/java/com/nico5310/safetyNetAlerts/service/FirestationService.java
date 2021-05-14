package com.nico5310.safetyNetAlerts.service;

import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.repository.FirestationRepositoryInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class FirestationService implements FirestationServiceInterface {

    @Autowired
    FirestationRepositoryInterface firestationRepositoryInterface;

    @Override
    public List<Firestation> findFirestationAll() {

        try {
            log.info("findFirestationAll SUCCESS :");
            return firestationRepositoryInterface.getFirestationAll();
        } catch (Exception exception) {
            log.error("findFirestationAll ERROR :" + exception.getMessage());
        }
        return null;
    }

    @Override
    public List<Firestation> saveFirestationList(Firestation firestation) {

        try {
            List<Firestation> saveFirestation = firestationRepositoryInterface.getFirestationAll();
            for (Firestation saveFire : saveFirestation) {
                if (saveFire.getAddress().equals(firestation.getAddress())) {
                    log.error("ERROR Cannot create Firestation List, he already exists :" + firestation);
                    return null;
                }
            }
            saveFirestation.add(firestation);
            log.info("Firestation saved SUCCESS :" + firestation);
            return saveFirestation;
        } catch (Exception exception) {
            log.error("saveFirestationList ERROR :" + exception.getMessage());
        }
        return null;
    }

    @Override
    public Firestation updateFirestationList(Firestation firestation) {

        if (firestation != null) {
            List<Firestation> updateFirestation;
            try {
                updateFirestation = firestationRepositoryInterface.getFirestationAll();
            } catch (Exception exception) {
                log.error("updateFirestationList ERROR" + exception.getMessage());
                return null;
            }
            for (Firestation update : updateFirestation) {
                if (update.getAddress().equals(firestation.getAddress())) { ///
                    update.setStation(firestation.getStation());
                    log.info("updateFirestationList SUCCESS" + firestation);
                    return update;
                }
            }
        }
        return null;
    }

    @Override
    public boolean deleteFirestationList(String address) {

        try {
            List<Firestation> deleteFirestation = firestationRepositoryInterface.getFirestationAll();
            return deleteFirestation.removeIf(firestation -> firestation.getAddress().equals(address));

        } catch (Exception exception) {
            log.error("deleteFirestationList ERROR :" + exception.getMessage());
        }
        log.info("deleteFirestationList SUCCESS :" + address);
        return false;
    }

    //Urls Endpoints
    @Override
    public Firestation findById(String firestationAddress) {

        try {
            for (Firestation address : firestationRepositoryInterface.getFirestationAll()) {
                if (address.getAddress().equals(firestationAddress)) {
                    log.info("findById SUCCESS :" + firestationAddress);
                    return address;
                }
            }
        } catch (Exception exception) {
            log.error("findById ERROR :" + exception.getMessage());
        }
        return null;
    }

    @Override
    public List<Firestation> findAddressByStation(int stationNumber) {

        try {
            List<Firestation> listFirestation = new ArrayList<>();
            for (Firestation firestation : firestationRepositoryInterface.getFirestationAll()) {
                if (firestation.getStation() == stationNumber) {
                    listFirestation.add(firestation);
                }
            }
            log.info("findAddressByStation SUCCESS :" + stationNumber);
            return listFirestation;
        } catch (Exception exception) {
            log.error("findAddressByStation ERROR :" + exception.getMessage());
        }
        return null;
    }


}

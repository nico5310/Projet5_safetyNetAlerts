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

    @Autowired
    public FirestationService(FirestationRepositoryInterface firestationRepositoryInterface) {
        this.firestationRepositoryInterface = firestationRepositoryInterface;
    }

    @Override
    public List<Firestation> findFirestationAll() {

        log.info("findFirestationAll SUCCESS :");
        return firestationRepositoryInterface.findFirestationAll();

    }

    @Override
    public List<Firestation> saveFirestationList(Firestation firestation) {


        log.info("Firestation saved SUCCESS :" + firestation);
        firestationRepositoryInterface.saveFirestationList(firestation);
        return firestationRepositoryInterface.saveFirestationList(firestation);

    }

    @Override
    public Firestation updateFirestationList(Firestation firestation) {

        log.info("updateFirestationList SUCCESS" + firestation);
        return firestationRepositoryInterface.updateFirestationList(firestation);
    }

    @Override
    public List<Firestation> deleteFirestationList(String address) {

        log.info("findById SUCCESS :" + address);
        firestationRepositoryInterface.deleteFirestationList(address);
        return firestationRepositoryInterface.findFirestationAll();

    }

    //Urls Endpoints
    @Override
    public Firestation findById(String firestationAddress) {

        log.info("findById SUCCESS :" + firestationAddress);
        return firestationRepositoryInterface.findById(firestationAddress);

    }

    @Override
    public List<Firestation> findAddressByStation(int stationNumber) {

        log.info("findAddressByStation SUCCESS :" + stationNumber);
        return firestationRepositoryInterface.findAddressByStation(stationNumber);
    }


}

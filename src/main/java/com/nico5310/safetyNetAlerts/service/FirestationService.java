package com.nico5310.safetyNetAlerts.service;


import com.nico5310.safetyNetAlerts.model.Firestation;
import com.nico5310.safetyNetAlerts.repository.FirestationRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // Bean class for Spring - Communicate with FirestationsRepository interface
@Data // Lombok annotation Getters and Setters.
public class FirestationService {

    @Autowired
    private final FirestationRepository firestationRepository;


}

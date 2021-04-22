package com.nico5310.safetyNetAlerts.repository;

import com.nico5310.safetyNetAlerts.model.Firestation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // Bean class for Spring -  communicate with Firestations class.
public interface FirestationRepository extends CrudRepository<Firestation, Long> {


}

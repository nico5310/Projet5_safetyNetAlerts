package com.nico5310.safetyNetAlerts.dto.url1firestation;

import lombok.Data;

import java.util.List;

@Data
public class PersonsByStation {

   private List<PersonStation> personStation;
   private int nbAdult;
   private int nbChild;

   @Override
   public String toString() {
      return "PersonsByStation [" + getPersonStation() + ", " + getNbAdult() + ", " + getNbChild() + "]";
   }

}

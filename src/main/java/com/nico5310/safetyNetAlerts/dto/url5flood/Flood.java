package com.nico5310.safetyNetAlerts.dto.url5flood;

import lombok.Data;

import java.util.List;

@Data
public class Flood {

   private String fireStation;
   private List<FamilyList> familyLists;

   @Override
    public String toString() {
       return  "Flood [" + getFireStation() + ", " + getFamilyLists() + "]";
   }

}

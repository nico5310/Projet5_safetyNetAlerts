package com.nico5310.safetyNetAlerts.dto.url5flood;

import lombok.Data;

import java.util.List;

@Data
public class FloodDto {

   private String              fireStation;
   private List<FamilyListDto> familyListDtos;

   @Override
    public String toString() {
       return "Flood [" + getFireStation() + ", " + getFamilyListDtos() + "]";
   }

}

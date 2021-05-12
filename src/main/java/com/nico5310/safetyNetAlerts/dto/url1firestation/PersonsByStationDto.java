package com.nico5310.safetyNetAlerts.dto.url1firestation;

import lombok.Data;

@Data
public class PersonsByStationDto {

   private String firstName;
   private String lastName;
   private String address;
   private String phone;
   private long adults;
   private long children;


   public PersonsByStationDto(String firstName, String lastName, String address, String phone, long adults, long children) {

      this.firstName = firstName;
      this.lastName  = lastName;
      this.address   = address;
      this.phone     = phone;
      this.adults    = adults;
      this.children  = children;
   }

   @Override
   public String toString() {
      return "PersonsByStationDto [=" + adults + ", children=" + children + ", PersonsByFirestation=" + listPersons.toString() + "]";
   }

}

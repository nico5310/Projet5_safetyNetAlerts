package com.nico5310.safetyNetAlerts.dto.url1firestation;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nico5310.safetyNetAlerts.model.Person;
import lombok.Data;

import java.util.List;

@Data
public class PersonsByStationDto {
   @JsonIgnoreProperties({"zip", "city", "email"})
   private List<Person> listPersons;
   private long adults;
   private long children;

   public PersonsByStationDto(List<Person> listPersons, long adults, long children) {

      this.listPersons = listPersons;
      this.adults      = adults;
      this.children    = children;
   }



   @Override
   public String toString() {
      return " [ PersonsByFirestation=" + listPersons.toString() + " adults=" + adults + ", children=" + children + "]";
   }

}

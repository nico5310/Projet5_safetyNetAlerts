package com.nico5310.safetyNetAlerts.dto.url1firestation;

import com.nico5310.safetyNetAlerts.model.Person;
import lombok.Data;

import java.util.List;

@Data
public class PersonsByStationDto {

   private List<Person> listPersons;
   private int adults;
   private int children;

   public PersonsByStationDto(List<Person> listPers, long nbAdult, long nbChild) {}

   @Override
   public String toString() {
      return "PersonsByStation [" + getListPersons() + ", " + getAdults() + ", " + getChildren() + "]";
   }

}

package com.nico5310.safetyNetAlerts.dto.url3phoneAlert;

import java.util.List;

public class PhoneAlertListDto {

    private final List<String> listPhonesCity;


    public PhoneAlertListDto(List<String> listPhonesCity) {

        this.listPhonesCity = listPhonesCity;
    }


    public List<String> getListPhonesCity() {

        return listPhonesCity;
    }


    //    @Override
    //    public String toString() {
    //        return "PhoneAlert " + getListPhonesCity() ;
    //    }

}

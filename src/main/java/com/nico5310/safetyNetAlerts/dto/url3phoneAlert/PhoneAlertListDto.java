package com.nico5310.safetyNetAlerts.dto.url3phoneAlert;

import java.util.List;

public class PhoneAlertListDto {

    private List<String> listPhonesCity;


    public PhoneAlertListDto(List<String> listPhonesCity) {
        this.listPhonesCity = listPhonesCity;
    }

    public PhoneAlertListDto() {}

    public List<String> getListPhonesCity() {

        return listPhonesCity;
    }

    public void setListPhonesCity(List<String> listPhonesCity) {

        this.listPhonesCity = listPhonesCity;
    }

    @Override
    public String toString() {
        return "PhoneAlert [" + getListPhonesCity() + "]";
    }

}

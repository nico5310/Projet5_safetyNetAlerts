package com.nico5310.safetyNetAlerts.dto.url3phoneAlert;

import lombok.Data;

import java.util.List;

@Data
public class PhoneAlertListDto {

    private List<String> listPhonesCity;

    /**
     * Constructeur of phoneNumberList
     *
     */
    public PhoneAlertListDto(List<String> listPhonesCity) {
        this.listPhonesCity = listPhonesCity;
    }


    @Override
    public String toString() {
        return "PhoneAlert [" + getListPhonesCity() + "]";
    }

}

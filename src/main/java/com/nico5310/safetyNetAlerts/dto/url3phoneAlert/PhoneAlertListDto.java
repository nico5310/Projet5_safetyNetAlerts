package com.nico5310.safetyNetAlerts.dto.url3phoneAlert;

import lombok.Data;

import java.util.List;

@Data
public class PhoneAlertListDto {

    private List<String> listPhones;

    /**
     * Constructeur of phoneNumberList
     *
     */
    public PhoneAlertListDto(List<String> listPhones) {
        this.listPhones = listPhones;
    }


    @Override
    public String toString() {
        return "PhoneAlert [" + getListPhones() + "]";
    }

}

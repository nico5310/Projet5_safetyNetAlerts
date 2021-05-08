package com.nico5310.safetyNetAlerts.dto.url3phoneAlert;

import lombok.Data;

import java.util.List;

@Data
public class PhoneAlertListDto {

    private List<String> phoneNumberList;

    /**
     * Constructeur of phoneNumberList
     * @param phoneNumberList
     */
    public PhoneAlertListDto(List<String> phoneNumberList) {
        this.phoneNumberList = phoneNumberList;
    }

    /**
     * Getter for phoneNumberList
     * @return phoneNumberList
     */
    public List<String> getPhoneNumberList() {
        return phoneNumberList;
    }


    @Override
    public String toString() {
        return "PhoneAlert [" + getPhoneNumberList() + "]";
    }

}

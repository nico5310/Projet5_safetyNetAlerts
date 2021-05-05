package com.nico5310.safetyNetAlerts.dto.url3phoneAlert;

import lombok.Data;

@Data
public class PhoneNumberList {

    private String phoneNumber;

    @Override
    public String toString() {
        return "PhoneNumber [" + getPhoneNumber() + "]";
    }

}

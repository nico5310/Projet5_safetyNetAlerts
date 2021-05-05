package com.nico5310.safetyNetAlerts.dto.url3phoneAlert;

import lombok.Data;

import java.util.List;

@Data
public class PhoneAlert {

    private List<PhoneNumberList> phoneNumberList;

    @Override
    public String toString() {
        return "PhoneAlert [" + getPhoneNumberList() + "]";
    }

}

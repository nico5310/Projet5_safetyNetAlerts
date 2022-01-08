package com.nico5310.safetyNetAlerts.dto.url7communityEmail;

import java.util.List;

public class EmailListDto {

    private final List<String> listEmails;

    public EmailListDto(List<String> listEmails) {

        this.listEmails = listEmails;
    }

    public List<String> getListEmails() {

        return listEmails;
    }


    @Override
    public String toString() {

        return "EmailList [" + getListEmails() + "]";
    }


}

package com.nico5310.safetyNetAlerts.dto.url7communityEmail;

import lombok.Data;

import java.util.List;

@Data
public class EmailListDto {

    private List<String> listEmails;

    public EmailListDto(List<String> listEmails) {

        this.listEmails = listEmails;
    }

    /**
     * Constructor
     */



    @Override
    public String toString(){
        return "EmailList [" + getListEmails() + "]";
    }


}

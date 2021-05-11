package com.nico5310.safetyNetAlerts.dto.url7communityEmail;

import lombok.Data;

import java.util.List;

@Data
public class EmailListDto {

    private String city;
    private List<String> listEmails;

    /**
     * Constructor
     */

    public EmailListDto(List<String> emailList) {}


    @Override
    public String toString(){
        return "EmailList [" + getListEmails() + "]";
    }


}

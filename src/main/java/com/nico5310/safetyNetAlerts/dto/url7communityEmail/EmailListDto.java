package com.nico5310.safetyNetAlerts.dto.url7communityEmail;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class EmailListDto {

    private List<String> listEmails;

    /**
     * Constructor
     */
    public EmailListDto(List<String> listEmails) {
        this.listEmails = listEmails;
    }


    @Override
    public String toString(){
        return "EmailList [" + getListEmails() + "]";
    }


}

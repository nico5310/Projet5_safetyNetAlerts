package com.nico5310.safetyNetAlerts.dto.url7communityEmail;

import lombok.Data;

import java.util.List;

@Data
public class EmailList {

   private List <String> email;

    public EmailList(List<String> email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return "EmailList [" + getEmail() + "]";
    }


}

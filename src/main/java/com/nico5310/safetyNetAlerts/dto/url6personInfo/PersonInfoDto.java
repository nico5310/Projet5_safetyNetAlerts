package com.nico5310.safetyNetAlerts.dto.url6personInfo;

import lombok.Data;

import java.util.List;

@Data
public class PersonInfoDto {

    private List<PersonInfoListDto> personInfoListDto;

    @Override
    public String toString() {
        return "PersonInfo [" + getPersonInfoListDto() + "]";
    }

}

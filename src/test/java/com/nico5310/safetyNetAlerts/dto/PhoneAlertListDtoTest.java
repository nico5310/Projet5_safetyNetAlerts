package com.nico5310.safetyNetAlerts.dto;

import com.nico5310.safetyNetAlerts.dto.url3phoneAlert.PhoneAlertListDto;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PhoneAlertListDtoTest {

    PhoneAlertListDto phoneAlertListDto = new PhoneAlertListDto();

    @Test
    @DisplayName("Test get list of phone")
    public void getListPhoneTest(){
        //GIVEN
        List<String> listPhonesCity = new ArrayList<String>();

        //WHEN
        phoneAlertListDto.setListPhonesCity(listPhonesCity);

        //THEN
        assertEquals(listPhonesCity, phoneAlertListDto.getListPhonesCity());

    }


}

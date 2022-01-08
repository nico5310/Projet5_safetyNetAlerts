package com.nico5310.safetyNetAlerts.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Actor Not Found")
public class NoFoundException extends RuntimeException {

    public NoFoundException(String message) {

        super(message);

    }


}

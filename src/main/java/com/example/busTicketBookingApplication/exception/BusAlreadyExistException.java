package com.example.busTicketBookingApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BusAlreadyExistException extends RuntimeException {
    //private String message;
    public BusAlreadyExistException(String regNo){
        super(String.format("Bus already exists with this number: '%s'",regNo));
    }

}

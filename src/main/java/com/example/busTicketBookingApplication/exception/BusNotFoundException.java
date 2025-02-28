package com.example.busTicketBookingApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BusNotFoundException extends RuntimeException{
    public BusNotFoundException (long busId){
        super(String.format("Bus with id - '%s' is not found",busId));
    }
}

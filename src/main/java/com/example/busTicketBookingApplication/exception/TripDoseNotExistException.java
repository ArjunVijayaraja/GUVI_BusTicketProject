package com.example.busTicketBookingApplication.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TripDoseNotExistException extends RuntimeException{
    public TripDoseNotExistException(long tripId){
        super(String.format("Trip dose not exist with id: '%s'",tripId));

    }
}

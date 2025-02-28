package com.example.busTicketBookingApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class DuplicateTripException extends RuntimeException{

    public DuplicateTripException(String fromLoc, String toLoc, String busNum, LocalDate tripDate){
        super(String.format("Trips already exist for '%s' to '%s' for '%s' on '%s'",fromLoc,toLoc,busNum,tripDate));
    }
}

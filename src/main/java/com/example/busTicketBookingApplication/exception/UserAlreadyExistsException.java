package com.example.busTicketBookingApplication.exception;

import com.example.busTicketBookingApplication.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserAlreadyExistsException  extends RuntimeException{
    public UserAlreadyExistsException(String userMail){
        super(String.format("User already exists with the provided mail '%s:",userMail));
    }
}

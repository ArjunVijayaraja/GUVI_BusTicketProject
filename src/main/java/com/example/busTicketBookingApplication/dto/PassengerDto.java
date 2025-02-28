package com.example.busTicketBookingApplication.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDto {
//    @JsonProperty("passengerName") - use this json property when the data from the frontend is has different names from the class property names;
    private String passengerName;
    private String passengerSeat;
    private String passengerMail;
    private String passengerGender;
    private int passengerAge;
    private String passengerContact;

}

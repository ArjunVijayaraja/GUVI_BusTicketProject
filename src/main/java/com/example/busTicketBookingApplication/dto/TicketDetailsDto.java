package com.example.busTicketBookingApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDetailsDto {

    private  String passengerName;
    private String passengerMail;
    private String passengerGender;
    private String passengerAge;
    private String passengerContact;



}

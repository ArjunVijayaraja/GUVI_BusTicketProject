package com.example.busTicketBookingApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class USerBookingListDto {

    private Float totalTicketCost;
//    private UserDto user;
    private BusTripDto busTrip;
    private int totalNoOfTickets;

}

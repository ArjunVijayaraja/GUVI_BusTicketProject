package com.example.busTicketBookingApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatDisplayDto {
    private long tripId;
    private String  busName;
    private String fromLocation;
    private String toLocation;
    private LocalDate tripDate;
    private float ticketPrice;

    private List<SeatDetailsDto> seatDetailsDto;

}

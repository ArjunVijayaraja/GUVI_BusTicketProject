package com.example.busTicketBookingApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookTicketDto {

    @NumberFormat(pattern = "#.##")
    private Float totalTicketCost;

    private List<PassengerDto> passengerDtoList;

    private long busTripId;





}

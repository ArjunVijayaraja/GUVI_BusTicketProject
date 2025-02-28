package com.example.busTicketBookingApplication.dto;

//import com.example.busTicketBookingApplication.entity.BoardingDroppingPoint;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripDto {

    private Long tripId;

    @NotEmpty(message = "Enter a 'from' location")
    private String fromLocation;

    @NotEmpty(message = "enter 'to' Location")
    private String toLocation;


//    private List<BoardingDroppingPointDto> boardingDroppingPointsDto;



}

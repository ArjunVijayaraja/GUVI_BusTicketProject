package com.example.busTicketBookingApplication.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatDetailsDto {

    private long seatId;

//    @JsonBackReference
//    @ToString.Exclude
//    private BusTripDto busTrip;

    @NotEmpty(message = "Seat Name cannot be empty")
    private String seatName;

//    private String seatType; //single or double


    private String seatAvailability; //Booked or available

}


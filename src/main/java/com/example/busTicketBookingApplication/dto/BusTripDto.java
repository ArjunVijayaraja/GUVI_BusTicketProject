package com.example.busTicketBookingApplication.dto;

import com.example.busTicketBookingApplication.entity.SeatDetails;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusTripDto {

    private long busTripId;

    @NotEmpty(message = "Bus name should not be empty")
    private String busTravelName;
    @NotEmpty(message = "enter registration number")
    private String busRegistrationNumber;

    @NotEmpty(message = "enter 'From' Location")
    private String fromLocation;
    @NotEmpty(message = "Enter 'to' Location")
    private String toLocation;

    @NotNull(message = "select a date")
    @FutureOrPresent(message = "past dates are not allowed")
    private LocalDate tripDate;

    @NotNull(message = "select a time")
//    @PastOrPresent(message = "past dates are not allowed")
    private LocalTime departureTime;

    @NotNull(message = "select a time")
//    @PastOrPresent(message = "past dates are not allowed")
    private LocalTime arrivalTime;

    @NotNull(message = "enter the ticket price")
    @Positive
    private float ticketPrice;

    private String tripStatus;

//    @JsonManagedReference
//    @ToString.Exclude
//    @OneToMany(mappedBy = "busTrip", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    @NotNull(message = "seat details cannot be empty")
    @Size(min = 10, message = "at least 10 seats to be created")
    private List<SeatDetailsDto> seatDetails;
}

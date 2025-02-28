package com.example.busTicketBookingApplication.dto;

import com.example.busTicketBookingApplication.entity.SeatDetails;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusTripViewDto {

    private long busId;
    private String busTravelName;
    private String busRegistrationNumber;
    private String seatingType;
    private String driverNumber;

}

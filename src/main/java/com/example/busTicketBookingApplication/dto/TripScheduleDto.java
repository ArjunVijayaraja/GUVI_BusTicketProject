package com.example.busTicketBookingApplication.dto;

//import com.example.busTicketBookingApplication.entity.Bus;
//import com.example.busTicketBookingApplication.entity.Trip;
//import com.example.busTicketBookingApplication.entity.TripScheduleAvailableSeat;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripScheduleDto {

    private Long tripScheduleId;
    private TripDto trip;
//    private BusViewDto bus;
    private LocalDateTime scheduleDateTime;
//    @JsonManagedReference
//    @ToString.Exclude
//    private List<TripScheduleAvailableSeatDto> tripScheduleAvailableSeats;

}

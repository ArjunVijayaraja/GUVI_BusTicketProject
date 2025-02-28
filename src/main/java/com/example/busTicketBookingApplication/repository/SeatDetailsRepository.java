package com.example.busTicketBookingApplication.repository;

import com.example.busTicketBookingApplication.entity.SeatDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatDetailsRepository extends JpaRepository<SeatDetails,Long> {

    List<SeatDetails> findByBusTrip_BusTripId(long busTripId);

}

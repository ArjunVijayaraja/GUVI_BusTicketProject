package com.example.busTicketBookingApplication.repository;

import com.example.busTicketBookingApplication.entity.BusTrip;
import com.example.busTicketBookingApplication.entity.SeatDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BusTripRepository extends JpaRepository<BusTrip,Long> {

    Optional<BusTrip> findByBusRegistrationNumberAndTripDate(String regNo, LocalDate tripDate);
    Optional<BusTrip> findByBusRegistrationNumberAndTripDateAndTripStatus(String regNo, LocalDate tripDate, String tripStatus);

    List<BusTrip> findByFromLocationAndToLocationAndTripDate(String fromLoc, String toLoc, LocalDate tripDate);

    @Query("SELECT DISTINCT b.fromLocation FROM BusTrip b")
    List<String> findDistinctFromLocations();

    @Query("SELECT DISTINCT b.toLocation FROM BusTrip b")
    List<String> findDistinctToLocations();
}

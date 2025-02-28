//package com.example.busTicketBookingApplication.repository;
//
////import com.example.busTicketBookingApplication.entity.Trip;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Optional;
//
//public interface TripRepository extends JpaRepository<Trip,Long> {
//    Optional<Trip> findByFromLocationAndToLocationAndBus_BusIdAndTripStatus(String fromLoc, String toLoc,long busId, String tripStatus);
//    List<Trip> findByFromLocationAndToLocationAndTripDate(String fromLocation, String toLocation, LocalDate tripDate);
// }

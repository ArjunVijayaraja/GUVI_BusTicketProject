//package com.example.busTicketBookingApplication.entity;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.ToString;
//
//import java.time.LocalDateTime;
//
//@Data
//@Entity
//@Table(name = "trip_seats_availability")
//public class TripSeatAvailability {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long tripSeatId;
//
//    @ManyToOne
////    @JsonManagedReference
//    @JsonBackReference
//    @ToString.Exclude
//    @JoinColumn(name = "fk_trip_id", nullable = false)
//    private Trip trip;
//
//    @ManyToOne
//    @JoinColumn(name = "fk_seat_id", nullable = false)
//    private SeatDetails seatDetails;
//
////    @Column(nullable = false)
////    private String seatPrice;
//
//    @Column(nullable = false)
//    private String seatStatus; // Booked or Available;
//
//    @Column
//    private LocalDateTime entryDate;
//
//    @Column
//    private LocalDateTime updatedDate;
//
//
//}

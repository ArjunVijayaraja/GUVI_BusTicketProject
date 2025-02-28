//package com.example.busTicketBookingApplication.entity;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
//import org.hibernate.annotations.ColumnDefault;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.util.List;
//
//@Data
//@Entity
//@Table(name = "trips")
//@AllArgsConstructor
//@NoArgsConstructor
//public class Trip {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long tripId;
//
//    @Column(nullable = false)
//    private String fromLocation;
//
//    @ManyToOne
//    @JoinColumn(name = "fk_bus_id")
//    private Bus bus;
//
//    @Column(nullable = false)
//    private String toLocation;
//
//    @Column
//    private LocalDate tripDate;
//
//    @Column
//    private LocalTime departureTime;
//
//    @Column
//    private LocalTime arrivalTime;
//
//    @Column
//    private LocalDateTime entryDate;
//
//    @Column
//    private float ticketPrice;
//
//    @Column
//    private String tripStatus; //completed or live
//
//    @OneToMany(mappedBy = "trip")
//    @JsonManagedReference
//    private List<TripSeatAvailability> tripSeatAvailability;
//
//
//
//
//
//
//
////    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
////    @JoinTable(name = "trip_boardingDropping",
////            joinColumns = @JoinColumn(name = "tripId",referencedColumnName = "tripId"),
////            inverseJoinColumns = @JoinColumn(name = "dbId",referencedColumnName = "dbId"))
////    @JsonManagedReference
////    private List<BoardingDroppingPoint> boardingDroppingPoints;
//
//
//
//}

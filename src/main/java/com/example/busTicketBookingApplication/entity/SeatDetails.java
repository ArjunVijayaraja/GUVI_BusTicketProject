package com.example.busTicketBookingApplication.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "seat_details")
@AllArgsConstructor
@NoArgsConstructor
public class SeatDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seatId;


    @JsonBackReference
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_busTrip_id")
    @ToString.Exclude
    private BusTrip busTrip;

    @Column(nullable = false)
    private String seatName; //A-1 , A2 etc

    @Column(nullable = false)
    private String seatAvailability; // available or booked




}

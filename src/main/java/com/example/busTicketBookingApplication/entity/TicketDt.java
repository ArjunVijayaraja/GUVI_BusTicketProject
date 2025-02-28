package com.example.busTicketBookingApplication.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tickets_dt")
@AllArgsConstructor
@NoArgsConstructor
public class TicketDt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ticketDtId;

    @Column
    private String passengerName;

    @Column
    private String passengerMail;

    @Column
    private String passengerGender;

    @Column
    private int passengerAge;

    @Column
    private String passengerContact;


    @ManyToOne(targetEntity = TicketHd.class)
    @ToString.Exclude
    @JsonManagedReference
    @JoinColumn(name = "fk_ticketHd_id")
    private TicketHd ticketHd;

    @Column
    private String ticketStatus; //confirmed or cancelled

    @Column
    private LocalDateTime entryDate;

    @Column LocalDateTime updatedData;
}

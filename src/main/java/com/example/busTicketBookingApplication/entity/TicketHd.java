package com.example.busTicketBookingApplication.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Entity
@Table(name = "ticketsHd")
public class TicketHd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ticketHdId;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;

    @Column
    private int totalNoOfTickets;

    @Column
    private Float totalTicketCost;

    @ManyToOne
    @JoinColumn(name = "fk_busTrip_id")
    private BusTrip busTrip;

    @Column
    private LocalDateTime entryDate;

//    @JsonBackReference
//    @ToString.Exclude
//    @OneToMany(mappedBy = "ticketHd", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
//    private List<TicketDt> ticketDt;


    @Column
    private String rzPayOrderId;

    @Column String paymentId;

    @Column
    private String ticketStatus;


    @Column
    private String paymentStatus;

}

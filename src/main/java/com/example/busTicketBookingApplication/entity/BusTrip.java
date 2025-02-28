    package com.example.busTicketBookingApplication.entity;

    import com.fasterxml.jackson.annotation.JsonBackReference;
    import com.fasterxml.jackson.annotation.JsonManagedReference;
    import jakarta.persistence.*;
    import jakarta.validation.constraints.NotEmpty;
    import lombok.Data;
    import lombok.ToString;

    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.time.LocalTime;
    import java.util.List;

    @Data
    @Entity
    @Table(name = "busTrips")
    public class BusTrip {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long busTripId;

        @Column(nullable = false)
        private String busTravelName;

        @Column
        private String busRegistrationNumber;

        @Column
        private String fromLocation;

        @Column
        private String toLocation;

        @Column
        private LocalDate tripDate;

        @Column
        private LocalTime departureTime;

        @Column
        private LocalTime arrivalTime;

        @Column
        private float ticketPrice;

        @Column(nullable = false, columnDefinition = "varchar(255) default 'LIVE'")
        private  String tripStatus;

        @JsonManagedReference
        @ToString.Exclude
        @OneToMany(mappedBy = "busTrip", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<SeatDetails> seatDetails;




    }

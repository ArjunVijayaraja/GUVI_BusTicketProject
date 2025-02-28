package com.example.busTicketBookingApplication.repository;

import com.example.busTicketBookingApplication.entity.Locations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Locations,Long> {
}

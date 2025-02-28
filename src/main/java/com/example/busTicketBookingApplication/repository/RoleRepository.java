package com.example.busTicketBookingApplication.repository;

import com.example.busTicketBookingApplication.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}

package com.example.busTicketBookingApplication.repository;

import com.example.busTicketBookingApplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserMail(String userMail);
}

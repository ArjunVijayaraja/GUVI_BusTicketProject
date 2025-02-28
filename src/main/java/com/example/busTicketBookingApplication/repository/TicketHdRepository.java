package com.example.busTicketBookingApplication.repository;

import com.example.busTicketBookingApplication.entity.TicketHd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TicketHdRepository extends JpaRepository<TicketHd,Long> {

       Optional<TicketHd> findByRzPayOrderId(String razorPayId);
       List<TicketHd> findByUser_userMail(String userMail);


}

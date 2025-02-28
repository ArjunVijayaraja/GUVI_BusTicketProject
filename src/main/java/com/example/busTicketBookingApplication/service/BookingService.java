package com.example.busTicketBookingApplication.service;

import com.example.busTicketBookingApplication.dto.BookTicketDto;
import com.example.busTicketBookingApplication.dto.USerBookingListDto;
import com.example.busTicketBookingApplication.dto.UserTicketListDto;
import com.example.busTicketBookingApplication.entity.TicketHd;

import java.util.List;

public interface BookingService {
    BookTicketDto bookTicket(BookTicketDto bookTicketDto);
    List<USerBookingListDto> getAllBookingsByUser(String userMail);
}

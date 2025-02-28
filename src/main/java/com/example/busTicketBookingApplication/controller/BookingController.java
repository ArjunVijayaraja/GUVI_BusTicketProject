package com.example.busTicketBookingApplication.controller;

import com.example.busTicketBookingApplication.dto.BookTicketDto;
import com.example.busTicketBookingApplication.dto.USerBookingListDto;
import com.example.busTicketBookingApplication.dto.UserTicketListDto;
import com.example.busTicketBookingApplication.entity.TicketHd;
import com.example.busTicketBookingApplication.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.print.Book;
import java.util.List;

@Controller
@AllArgsConstructor
public class BookingController {
    private BookingService bookingService;




    @PostMapping("/bookTicket")
    public String bookTicket(@ModelAttribute("BookTicketDto") BookTicketDto bookTicketDto){

        BookTicketDto bookedTicket = bookingService.bookTicket(bookTicketDto);
        System.out.println(bookedTicket);
        return "redirect:/home";

    }

    @GetMapping("/getAllUserBookings")
    public String getTicketsByUser(Model model){
        String userMail = SecurityContextHolder.getContext().getAuthentication().getName();
      List<USerBookingListDto
              > userBookingListDto = bookingService.getAllBookingsByUser(userMail);
      model.addAttribute("USerBookingListDto",userBookingListDto);
      return "user-trip-bookingList";
    }

}

package com.example.busTicketBookingApplication.service.ServiceImpl;

import com.example.busTicketBookingApplication.dto.BookTicketDto;
import com.example.busTicketBookingApplication.dto.USerBookingListDto;
import com.example.busTicketBookingApplication.dto.UserTicketListDto;
import com.example.busTicketBookingApplication.entity.BusTrip;
import com.example.busTicketBookingApplication.entity.TicketDt;
import com.example.busTicketBookingApplication.entity.TicketHd;
import com.example.busTicketBookingApplication.entity.User;
import com.example.busTicketBookingApplication.exception.TripDoseNotExistException;
import com.example.busTicketBookingApplication.repository.BusTripRepository;
import com.example.busTicketBookingApplication.repository.TicketDtRepository;
import com.example.busTicketBookingApplication.repository.TicketHdRepository;
import com.example.busTicketBookingApplication.repository.UserRepository;
import com.example.busTicketBookingApplication.service.BookingService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cglib.core.Local;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private BusTripRepository busTripRepository;
    private TicketHdRepository ticketHdRepository;
    private TicketDtRepository ticketDtRepository;
    private ModelMapper modelMapper;
    private UserRepository userRepository;

    @Override
    public BookTicketDto bookTicket(BookTicketDto bookTicketDto) {

        User user=  userRepository.findByUserMail(SecurityContextHolder.getContext().getAuthentication().getName()).get();

        BusTrip optionalBusTrip = busTripRepository.findById(bookTicketDto.getBusTripId()).orElseThrow(
                () -> new TripDoseNotExistException(bookTicketDto.getBusTripId()));
        TicketHd ticketHd = modelMapper.map(bookTicketDto, TicketHd.class);
        ticketHd.setTotalNoOfTickets(bookTicketDto.getPassengerDtoList().size());
        ticketHd.setBusTrip(optionalBusTrip);
        ticketHd.setUser(user);
        ticketHd.setEntryDate(LocalDateTime.now());
        ticketHd.setTicketStatus("CONFIRMED");
        ticketHd.setTotalTicketCost(ticketHd.getTotalTicketCost());
        TicketHd savedTicket = ticketHdRepository.save(ticketHd);


        List<TicketDt> ticketDtList = bookTicketDto.getPassengerDtoList().stream().map(
                i -> {
                    TicketDt ticketDt = modelMapper.map(i, TicketDt.class);
                    ticketDt.setTicketHd(savedTicket);
                    ticketDt.setEntryDate(LocalDateTime.now());
                    ticketDt.setTicketStatus("CONFIRMED");
                    ticketDt.setUpdatedData(LocalDateTime.now());
                    return ticketDt;
                }).collect(Collectors.toList());

        ticketDtRepository.saveAll(ticketDtList);


        return modelMapper.map(savedTicket,BookTicketDto.class);
    }

    @Override
    public List<USerBookingListDto> getAllBookingsByUser(String userMail) {
        List<TicketHd> bookingList =ticketHdRepository.findByUser_userMail(SecurityContextHolder.getContext().getAuthentication().getName());
        return bookingList.stream().map(i->modelMapper.map(i, USerBookingListDto.class)).collect(Collectors.toList());
    }


}

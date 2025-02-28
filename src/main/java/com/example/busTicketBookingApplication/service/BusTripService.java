package com.example.busTicketBookingApplication.service;

import com.example.busTicketBookingApplication.dto.BusTripDto;
import com.example.busTicketBookingApplication.dto.SeatDetailsDto;
import com.example.busTicketBookingApplication.entity.BusTrip;

import java.util.List;

public interface BusTripService {
    BusTripDto createBus(BusTripDto busTripDto);
    List<BusTripDto> getAllBus();
    List<SeatDetailsDto> getAvailableTripSeats(long busTripId);
    BusTripDto findByBusId(long id);
    List<BusTripDto> findBusByRoute(BusTripDto busTripDto);
    BusTripDto createBusTrip(BusTripDto busTripDto);
}


//package com.example.busTicketBookingApplication.controller;
//
//import com.example.busTicketBookingApplication.Service.TripService;
//import com.example.busTicketBookingApplication.dto.BUS_TRIP_DTO;
//import com.example.busTicketBookingApplication.entity.Trip;
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@AllArgsConstructor
//public class TripController {
//    private TripService tripService;
//
//    @PostMapping("/create-trip/{busId}")
//    public ResponseEntity<Trip> createTrip(@RequestBody Trip trip, @PathVariable("busId") long busId){
//       Trip createdTrip = tripService.createTrip(trip,busId);
//       return new ResponseEntity<>(createdTrip, HttpStatus.CREATED);
//    }
//
//
//    @GetMapping("/getBus")
//    public ResponseEntity<List<BUS_TRIP_DTO>> findBusForTrip(@RequestBody BUS_TRIP_DTO busTripDto ){
//        List<BUS_TRIP_DTO> availableBusses = tripService.findBuByTripRoute(busTripDto);
//        return new ResponseEntity<>(availableBusses,HttpStatus.OK);
//    }
//}

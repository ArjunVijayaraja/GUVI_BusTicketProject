//package com.example.busTicketBookingApplication.controller;
//
////import com.example.busTicketBookingApplication.Service.BusService;
//import com.example.busTicketBookingApplication.dto.BusTripDto;
////import com.example.busTicketBookingApplication.entity.Bus;
//import com.example.busTicketBookingApplication.dto.SeatDetailsDto;
//import com.example.busTicketBookingApplication.dto.SeatDisplayDto;
//import com.example.busTicketBookingApplication.service.BusTripService;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
////@RequestMapping("/bus")
//@AllArgsConstructor
//public class BusController {
//    private BusTripService busTripService;
//
//    @PostMapping("/createBus-trip")
//    public ResponseEntity<BusTripDto> createBus(@RequestBody BusTripDto busTripDto) {
//        BusTripDto savedBus = busTripService.createBus(busTripDto);
//        return new ResponseEntity<BusTripDto>(savedBus, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/get-allBus")
//    public ResponseEntity<List<BusTripDto>> getAllBus(){
//        List<BusTripDto> busList = busTripService.getAllBus();
//        return new ResponseEntity<List<BusTripDto>>(busList,HttpStatus.OK);
//    }
//
////    @GetMapping("/trip-seats/{Bus-TripId}")
////    public ResponseEntity<List<SeatDetailsDto>> getTripSeatDetails(@PathVariable("Bus-TripId") long busTripId){
////        List<SeatDetailsDto> seatDetailsDtoLst = busTripService.getAvailableTripSeats(busTripId);
////        return new ResponseEntity<>(seatDetailsDtoLst,HttpStatus.OK);
////
////    }
//
//    @GetMapping("/trip-seats/{Bus-TripId}")
//    public ResponseEntity<SeatDisplayDto> getTripSeatDetails(@PathVariable("Bus-TripId") long busTripId){
//        List<SeatDetailsDto> seatDetailsDtoLst = busTripService.getAvailableTripSeats(busTripId);
//        BusTripDto busTripDto = busTripService.findByBusId(busTripId);
//        SeatDisplayDto seatDisplayDto = new SeatDisplayDto();
//        seatDisplayDto.setBusName(busTripDto.getBusTravelName());
//        seatDisplayDto.setFromLocation(busTripDto.getFromLocation());
//        seatDisplayDto.setToLocation(busTripDto.getToLocation());
//        seatDisplayDto.setSeatDetailsDto(seatDetailsDtoLst);
//        return new ResponseEntity<>(seatDisplayDto,HttpStatus.OK);
//
//    }
//
//    @GetMapping("/findBus")
//    public ResponseEntity<List<BusTripDto>> findBusByRoute(@RequestBody BusTripDto busTripDto) {
//
//       List<BusTripDto> availableBusses = busTripService.findBusByRoute(busTripDto);
//       return new ResponseEntity<>(availableBusses,HttpStatus.OK);
//
//
//    }
//
//
//
//
//
//}
//
//
//
//

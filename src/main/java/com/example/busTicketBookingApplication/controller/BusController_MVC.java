package com.example.busTicketBookingApplication.controller;

import com.example.busTicketBookingApplication.dto.BusTripDto;
import com.example.busTicketBookingApplication.dto.SeatDetailsDto;
import com.example.busTicketBookingApplication.dto.SeatDisplayDto;
import com.example.busTicketBookingApplication.dto.TicketDetailsDto;
import com.example.busTicketBookingApplication.entity.Locations;
import com.example.busTicketBookingApplication.service.BusTripService;
import com.example.busTicketBookingApplication.service.LocationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@Controller
//@RequestMapping("/bus")
@AllArgsConstructor
public class BusController_MVC {
    private BusTripService busTripService;
    private LocationService locationService;




//    @GetMapping("/view-tripMaster")
//    public String getBusTripMaster(Model model){
//        BusTripDto busTripDto = new BusTripDto();
//        model.addAttribute("busTripData",busTripDto);
//        return "busTripMaster";
//
//    }

//    @PostMapping("/create-trip")
//    public String createTrip(@Valid @ModelAttribute("busTripData") BusTripDto busTripDto, BindingResult result,Model model){
//
//        if(result.hasErrors()){
//            model.addAttribute("busTripData",busTripDto);
//            return"busTripMaster";
//        }
//
//
//        BusTripDto savedBusTripDto = busTripService.createBusTrip(busTripDto);
//        model.addAttribute("busTripData", savedBusTripDto);
//
//            return "busTripMaster";
////        return "redirect:/create-trip?success";
//    }


//    @PostMapping("/createBus-trip")
//    public ResponseEntity<BusTripDto> createBus(@RequestBody BusTripDto busTripDto ) {
//        BusTripDto savedBus = busTripService.createBus(busTripDto);
//        return new ResponseEntity<BusTripDto>(savedBus, HttpStatus.CREATED);
//    }

//    @GetMapping("/get-allBus")
//    public String getAllBus(Model model){
//        List<BusTripDto> busList = busTripService.getAllBus();
//        model.addAttribute("busList",busList);
//        return "view-allBus-trips";
//    }


//    @GetMapping("/get-allBus")
//    public ResponseEntity<List<BusTripDto>> getAllBus(){
//        List<BusTripDto> busList = busTripService.getAllBus();
//        return new ResponseEntity<List<BusTripDto>>(busList,HttpStatus.OK);
//    }

//    @GetMapping("/trip-seats/{Bus-TripId}")
//    public ResponseEntity<List<SeatDetailsDto>> getTripSeatDetails(@PathVariable("Bus-TripId") long busTripId){
//        List<SeatDetailsDto> seatDetailsDtoLst = busTripService.getAvailableTripSeats(busTripId);
//        return new ResponseEntity<>(seatDetailsDtoLst,HttpStatus.OK);
//
//    }

    @GetMapping("/trip-seats/{Bus-TripId}")
    public String getTripSeatDetails(@PathVariable("Bus-TripId") long busTripId, Model model){
        List<SeatDetailsDto> seatDetailsDtoLst = busTripService.getAvailableTripSeats(busTripId);
        BusTripDto busTripDto = busTripService.findByBusId(busTripId);
        SeatDisplayDto seatDisplayDto = new SeatDisplayDto();
        seatDisplayDto.setBusName(busTripDto.getBusTravelName());
        seatDisplayDto.setFromLocation(busTripDto.getFromLocation());
        seatDisplayDto.setToLocation(busTripDto.getToLocation());
        seatDisplayDto.setSeatDetailsDto(seatDetailsDtoLst);
        seatDisplayDto.setTripDate(busTripDto.getTripDate());
        seatDisplayDto.setTicketPrice(busTripDto.getTicketPrice());
        seatDisplayDto.setTripId(busTripId);
        List<SeatDetailsDto> seatDetailsDtoList = busTripService.getAvailableTripSeats(busTripId);
        model.addAttribute("seatList",seatDetailsDtoList);
        model.addAttribute("seatDisplayDto", seatDisplayDto);
        return "seatSelection";

    }

    @GetMapping("/findBus")
    public String findBus(@ModelAttribute("findBusDto") BusTripDto busTripDto , Model model) {
        List<BusTripDto> busTripDtoList = busTripService.findBusByRoute(busTripDto);
        model.addAttribute("tripBusList",busTripDtoList);
        return "viewTripBus";
    }





}





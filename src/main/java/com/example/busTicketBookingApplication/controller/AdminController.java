package com.example.busTicketBookingApplication.controller;

import com.example.busTicketBookingApplication.dto.BusTripDto;
import com.example.busTicketBookingApplication.service.BusTripService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private BusTripService busTripService;

    @GetMapping("/get-allBus")
    public String getAllBus(Model model){
        List<BusTripDto> busList = busTripService.getAllBus();
        model.addAttribute("busList",busList);
        return "view-allBus-trips";
    }

    @GetMapping("/view-tripMaster")
    public String getBusTripMaster(Model model){
        BusTripDto busTripDto = new BusTripDto();
        model.addAttribute("busTripData",busTripDto);
        return "busTripMaster";

    }


    @PostMapping("/create-trip")
    public String createTrip(@Valid @ModelAttribute("busTripData") BusTripDto busTripDto, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("busTripData",busTripDto);
            return"busTripMaster";
        }
//        BusTripDto savedBusTripDto = busTripService.createBusTrip(busTripDto);
        BusTripDto savedBusTripDto = busTripService.createBusTrip(busTripDto);
        model.addAttribute("busTripData", savedBusTripDto);
        return "busTripMaster";
    }
}

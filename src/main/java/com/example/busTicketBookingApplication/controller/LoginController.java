package com.example.busTicketBookingApplication.controller;

import com.example.busTicketBookingApplication.dto.BusTripDto;
import com.example.busTicketBookingApplication.entity.Locations;
import com.example.busTicketBookingApplication.repository.BusTripRepository;
import com.example.busTicketBookingApplication.service.BusTripService;
import com.example.busTicketBookingApplication.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class LoginController {

    private BusTripService busTripService;
    private LocationService locationService;
    private BusTripRepository busTripRepository;

    @GetMapping("/")
    public String login(){
        return "loginPage";
    }

//    @GetMapping("/login")
//    public String getHomePage(){
//        return "home";
//    }

    @GetMapping("/home")
    public String loadHomePage(Model model){
        BusTripDto busTripDto = new BusTripDto();
        model.addAttribute("findBusDto",busTripDto);
        List<BusTripDto> busTripDtoList = busTripService.getAllBus();
        List<String> fromLocationList = busTripRepository.findDistinctFromLocations();
        List<String> toLocationList = busTripRepository.findDistinctToLocations();
        List<Locations> locationsList = locationService.getAllLocation();
        model.addAttribute("fromLocationList",fromLocationList);
        model.addAttribute("toLocationList",toLocationList);
        model.addAttribute("locationsList",locationsList);
        model.addAttribute("listOfBus",busTripDtoList);
        return "home";
    }


}

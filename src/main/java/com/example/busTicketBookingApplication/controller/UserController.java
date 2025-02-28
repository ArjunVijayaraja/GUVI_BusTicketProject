package com.example.busTicketBookingApplication.controller;

import com.example.busTicketBookingApplication.dto.UserDto;
import com.example.busTicketBookingApplication.entity.User;
import com.example.busTicketBookingApplication.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/user-registration")
    public String getRegistrationPage(@ModelAttribute("userModelObject") UserDto userDto, Model model){
        UserDto userDto1 = new UserDto();
        model.addAttribute("userModelObject",userDto);

        return "userRegistration";
    }

    @PostMapping("/createUser")
    public String createUser(@Valid @ModelAttribute("userModelObject") UserDto userDto, BindingResult result, Model model, RedirectAttributes redirectAttributes){

        if(result.hasErrors()){
            model.addAttribute("userModelObject", userDto);
            return "userRegistration";
        }
        UserDto savedUser = userService.createUser(userDto);
        redirectAttributes.addFlashAttribute("userModelObject", savedUser);
        return "redirect:/user-registration?success";


    }
}

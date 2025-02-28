package com.example.busTicketBookingApplication.service;

import com.example.busTicketBookingApplication.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);
    List<UserDto> getAllUsers();
    UserDto findUserByMailId(String userMail);
    UserDto updateUser(UserDto userDto);


}

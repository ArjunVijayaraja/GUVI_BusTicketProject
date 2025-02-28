package com.example.busTicketBookingApplication.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long userId;
    @NotEmpty(message = "user name should not be empty")
    private String userName;
    @NotEmpty(message = "user mail should not be empty")
    private  String userMail;
    @NotEmpty(message = "password should not be empty")
    private String password;
    @NotEmpty(message = "COntact should not be empty")
    private String  userContact;



}

package com.example.busTicketBookingApplication.dto;

import com.example.busTicketBookingApplication.entity.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private long customerId;

    @NotEmpty(message = "name Should not be empty")
    private String customerName;
    @NotEmpty(message = "mail should not be empty")
    private String customerMail;
    @NotEmpty(message = "provide contact details")
    private String customerContact;
    @NotEmpty(message = "enter a password")
    private String password;

    private Set<Role> roles;
}

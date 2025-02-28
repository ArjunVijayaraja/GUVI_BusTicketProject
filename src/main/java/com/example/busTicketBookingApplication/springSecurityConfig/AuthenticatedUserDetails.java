package com.example.busTicketBookingApplication.springSecurityConfig;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticatedUserDetails {

    public static String getLoggedInUserMail(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();

    }
}

//package com.example.busTicketBookingApplication.razorPayConfig;
//
//import com.razorpay.RazorpayClient;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RazorPayConfig {
//    @Value("${razorpay.api.key}")
//    private String API_KEY;
//
//    @Value("${razorpay.api.secret}")
//    private String API_SECRET;
//
//    @Bean
//    public RazorpayClient razorpayClient() throws Exception {
//        return new RazorpayClient(API_KEY, API_SECRET);
//    }
//}

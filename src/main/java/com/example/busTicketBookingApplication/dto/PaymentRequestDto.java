package com.example.busTicketBookingApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDto {

    private float totalTicketPrice;

    private List<PassengerDto> passengerDtoList;

    private String razorPayOrderId;
    private String razorPayOrderStatus;
    private boolean success;
    private String paymentOptions;
    private String paymentId;




}

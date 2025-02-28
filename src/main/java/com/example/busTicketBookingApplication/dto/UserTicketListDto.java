package com.example.busTicketBookingApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTicketListDto {

    private List<USerBookingListDto> ticketHd;

}

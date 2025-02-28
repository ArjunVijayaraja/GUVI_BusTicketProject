//package com.example.busTicketBookingApplication.controller;
//
//import com.example.busTicketBookingApplication.dto.PaymentDetails;
//import com.example.busTicketBookingApplication.dto.PaymentRequestDto;
//import com.example.busTicketBookingApplication.entity.TicketHd;
////import com.example.busTicketBookingApplication.service.ServiceImpl.PaymentService;
//import com.razorpay.Order;
//import com.razorpay.RazorpayClient;
//import com.razorpay.RazorpayException;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@Controller
//@AllArgsConstructor
//public class PaymentController {
//    @Autowired
//    private PaymentService paymentService;
//
//    @PostMapping("/makePayment/{tripBusId}")
//    @ResponseBody
//    public ResponseEntity<PaymentRequestDto> bookTicket(@RequestBody PaymentRequestDto paymentRequestDto, @PathVariable("tripBusId") long tripBusId) throws RazorpayException {
////        try{
////            // Create Razorpay order
////            RazorpayClient client = new RazorpayClient("afafasd","asdasdasd");
////            JSONObject orderRequest = new JSONObject();
////            orderRequest.put("amount", paymentRequestDto.getTotalTicketPrice()*100);
////            orderRequest.put("currency","INR");
////            orderRequest.put("payment_capture",1);
////            Order order = client.orders.create(orderRequest);
////
////            // Return order details to frontend
////
////
////
////
////
////        } catch (RazorpayException e) {
////            throw new RuntimeException(e);
////        }
//     PaymentRequestDto createdPayment = paymentService.createPayment(paymentRequestDto,tripBusId);
//     return  new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
//
//    }
//
//    @PostMapping("/savePaymentId")
//    public ResponseEntity<String> savePaymentId(@RequestBody PaymentDetails paymentDetails){
//        String paymentId = paymentDetails.getPaymentId();
//        String orderId = paymentDetails.getOrder_Id();
//        String savedPaymentId = paymentService.savePaymentId(orderId,paymentId);
//        return ResponseEntity.ok(paymentId);
//
//    }
//
//
//
//
//
//}
//

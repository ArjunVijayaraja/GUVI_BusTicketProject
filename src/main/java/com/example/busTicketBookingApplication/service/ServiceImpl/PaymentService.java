//package com.example.busTicketBookingApplication.service.ServiceImpl;
//
//import com.example.busTicketBookingApplication.dto.PassengerDto;
//import com.example.busTicketBookingApplication.dto.PaymentRequestDto;
//import com.example.busTicketBookingApplication.entity.TicketHd;
//import com.example.busTicketBookingApplication.repository.BusTripRepository;
//import com.example.busTicketBookingApplication.repository.TicketDtRepository;
//import com.example.busTicketBookingApplication.repository.TicketHdRepository;
//import com.razorpay.Order;
//import com.razorpay.RazorpayClient;
//import com.razorpay.RazorpayException;
//import lombok.AllArgsConstructor;
//import org.json.JSONObject;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.PropertyMap;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
//@Service
////@AllArgsConstructor
//public class PaymentService {
//    @Autowired
//    private TicketHdRepository ticketHdRepository;
//    @Autowired
//    private RazorpayClient client;
//    @Autowired
//    private ModelMapper modelMapper;
//    @Autowired
//    private BusTripRepository busTripRepository;
//    //private RazorpayClient client;
//
////    @Value("${razorpay.api.key}")
////    private String razorpayKey;
////
////    @Value("${razorpay.api.secret}")
////    private String razorpaySecret;
//
//
//    @Value("${razorpay.api.key}")
//    private String key;
//
//    public String getRazorPayKey(){
//
//        return key;
//
//    }
//
//    public PaymentRequestDto createPayment(PaymentRequestDto paymentRequestDto, long tripBusId) throws RazorpayException {
//        JSONObject orderRequest = new JSONObject();
//        orderRequest.put("amount",paymentRequestDto.getTotalTicketPrice()*100);
//        orderRequest.put("currency","INR");
//        orderRequest.put("receipt","arjun00800@gmail.com");
//
//        //creting order in razorPay
////        this.client = new RazorpayClient();
//        Order razorPayOrder = client.orders.create(orderRequest);
//        System.out.println(razorPayOrder);
//        paymentRequestDto.setRazorPayOrderId(razorPayOrder.get("id"));
//        paymentRequestDto.setRazorPayOrderStatus(razorPayOrder.get("status"));
//        List<PassengerDto> passengerDtoList = paymentRequestDto.getPassengerDtoList();
//        TicketHd ticketHd =  modelMapper.map(paymentRequestDto, TicketHd.class);
//        ticketHd.setTicketStatus(razorPayOrder.get("status"));
//        ticketHd.setRzPayOrderId(razorPayOrder.get("id"));
//        ticketHd.setTotalNoOfTickets(paymentRequestDto.getPassengerDtoList().size());
//        ticketHd.setBusTrip(busTripRepository.findById(tripBusId).get());
//        ticketHd.setEntryDate(LocalDateTime.now());
//        ticketHd.setTotalTicketCost(paymentRequestDto.getTotalTicketPrice());
//
//       TicketHd savedTicket =  ticketHdRepository.save(ticketHd);
//
//       PaymentRequestDto responseDto = mapTicketHdToPaymentRequestDto(savedTicket);
//       responseDto.setSuccess(true);
//
//        // Payment options to be returned to frontend
//        JSONObject paymentOptions = new JSONObject();
//        paymentOptions.put("key",getRazorPayKey());
//        paymentOptions.put("amount",ticketHd.getTotalTicketCost()*100);
//        paymentOptions.put("currency","INR");
//        paymentOptions.put("order_id", ticketHd.getRzPayOrderId());
//        paymentOptions.put("name","TestUser frmPaymentService");
//        paymentOptions.put("email","arjun00800@gmail.com");
//        paymentOptions.put("contact","9500646167");
//        responseDto.setPaymentOptions(paymentOptions.toString());
//        return responseDto;
//    }
//
//    public String savePaymentId(String orderId,String paymentId){
//        Optional<TicketHd> optionalTicketHd = ticketHdRepository.findByRzPayOrderId(orderId);
//        if(optionalTicketHd.isPresent()){
//            optionalTicketHd.get().setPaymentId(paymentId);
//            TicketHd savedTicketHd =  ticketHdRepository.save(optionalTicketHd.get());
//            return "PaymentId"+savedTicketHd.getPaymentId();
//        }
//        else {
//            System.out.println("Not OrderId found");
//            return "Not OrderId found";
//        }
//
//
//
//    }
//
//
//
//
//
//
//
//
//    public PaymentRequestDto mapTicketHdToPaymentRequestDto(TicketHd ticketHd){
//
////        this.modelMapper = new ModelMapper();
//        modelMapper.typeMap(TicketHd.class, PaymentRequestDto.class)
//                .addMappings(mapper->{
//                    mapper.map(TicketHd::getPaymentStatus,PaymentRequestDto::setRazorPayOrderStatus);
//                    mapper.map(TicketHd::getRzPayOrderId,PaymentRequestDto::setRazorPayOrderId);
//                    mapper.map(TicketHd::getTotalTicketCost,PaymentRequestDto::setTotalTicketPrice);
//                });
//        return modelMapper.map(ticketHd, PaymentRequestDto.class);
//    }
//
//
//
//
//
//
//}

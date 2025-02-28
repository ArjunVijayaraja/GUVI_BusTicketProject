package com.example.busTicketBookingApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusAlreadyExistException.class)
    public ResponseEntity<ErrorDetails> handleBusAlreadyExistsException(BusAlreadyExistException exception,
                                                                        WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "DUPLICATE REG NUMBER - BUS ALREADY EXISTS.."
        );
        return  new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateTripException.class)
    public ResponseEntity<ErrorDetails> handleDuplicateTripException(DuplicateTripException exception,
                                                                        WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "DUPLICATE TRIP....."
        );
        return  new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(BoardingDroppingPointAlreadyExistException.class)
//    public ResponseEntity<ErrorDetails> handleBoardingDroppingPointAlreadyExistException(BoardingDroppingPointAlreadyExistException exception,
//                                                                     WebRequest webRequest){
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "DUPLICATE Boarding/Dropping Point....."
//        );
//        return  new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(BusNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleBusNotFoundException(BusNotFoundException exception, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "BUS NOT FOUND / BUS NOT AVAILABLE"
        );
        return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TripDoseNotExistException.class)
    public ResponseEntity<ErrorDetails> handleTripDoseNotExistException(TripDoseNotExistException exception, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "TRIP dose not exist!"
        );
        return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
    }

}

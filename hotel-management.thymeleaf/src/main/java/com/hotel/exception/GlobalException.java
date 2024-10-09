package com.hotel.exception;

import com.hotel.payload.ApiResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler
    public ApiResponse userNotFoundException(UserNotFoundException e) {
        String message = e.getMessage();
        return new ApiResponse(message, false);
    }
    
    @ExceptionHandler
    public ApiResponse bookingNotFoundException(BookingNotFoundException e) {
        String message = e.getMessage();
        return new ApiResponse(message, false);
    }
    
    @ExceptionHandler
    public ApiResponse paymentNotFoundException(PaymentNotFoundException e) {
        String message = e.getMessage();
        return new ApiResponse(message, false);
    }
    
    @ExceptionHandler
    public ApiResponse roomNotFoundException(RoomNotFoundException e) {
        String message = e.getMessage();
        return new ApiResponse(message, false);
    }
    
    @ExceptionHandler
    public ApiResponse reviewNotFoundException(ReviewNotFoundException e) {
        String message = e.getMessage();
        return new ApiResponse(message, false);
    }
}

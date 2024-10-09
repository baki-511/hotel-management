package com.hotel.exception;

public class BookingNotFoundException extends RuntimeException{
    public BookingNotFoundException(Long bookingId) {
        super("Booking NOT Found With ID : " + bookingId);
    }
    
    public BookingNotFoundException(String msg) {
        super(msg);
    }
}

package com.hotel.service;

import com.hotel.entity.Booking;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    public List<Booking> getAllBooking();
    
    public List<Booking> occupiedBookings(LocalDate start, LocalDate end);
    
    public Booking getBookingById(Long bookingId);
    
}

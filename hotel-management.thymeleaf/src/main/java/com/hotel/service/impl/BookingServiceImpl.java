package com.hotel.service.impl;

import com.hotel.entity.Booking;
import com.hotel.exception.BookingNotFoundException;
import com.hotel.repository.BookingRepository;
import com.hotel.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    
    @Override
    public List<Booking> getAllBooking() {
        return bookingRepository.findAll();
    }
    
    @Override
    public List<Booking> occupiedBookings(LocalDate start, LocalDate end) {
        return getAllBooking().stream()
                .filter(d ->(((start.isAfter(d.getCheckInDate())) && start.isBefore(d.getCheckOutDate())) ||
                        ((end.isAfter(d.getCheckInDate())) && end.isBefore(d.getCheckOutDate())))
                        ||
                        ((((d.getCheckInDate().isAfter(start)) && (d.getCheckInDate().isBefore(end)) ||
                                ( d.getCheckInDate().equals(start) || d.getCheckOutDate().equals(start))
                        ))
                                ||
                                (((d.getCheckOutDate().isAfter(start)) && (d.getCheckOutDate().isBefore(end)) ||
                                        ( d.getCheckInDate().equals(end) || d.getCheckOutDate().equals(end))
                                ))
                        )
                )
                .collect(Collectors.toList());
    }
    
    @Override
    public Booking getBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId)
                .orElseThrow(()->new BookingNotFoundException(bookingId));
    }
}

package com.hotel.service.impl;

import com.hotel.entity.BookDetail;
import com.hotel.exception.BookingNotFoundException;
import com.hotel.repository.BookDetailRepository;
import com.hotel.service.CustomerBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerBookingDetailService implements CustomerBookingService {
    @Autowired
    private BookDetailRepository bookDetailRepository;
    
    @Override
    public List<BookDetail> getAllCustomerBookingDetails() {
        return bookDetailRepository.findAll();
    }
    
    @Override
    public BookDetail getBookDetailById(Integer bookId) {
        return bookDetailRepository.findById(bookId)
                .orElseThrow(()->new BookingNotFoundException("Booking Details NOT Found!!"));
    }
}

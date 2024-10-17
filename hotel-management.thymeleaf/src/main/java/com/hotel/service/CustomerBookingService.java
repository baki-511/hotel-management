package com.hotel.service;

import com.hotel.entity.BookDetail;

import java.util.List;

public interface CustomerBookingService {
    public List<BookDetail> getAllCustomerBookingDetails();
    
    public BookDetail getBookDetailById(Integer bookId);
}

package com.hotel.service;

import com.hotel.entity.User;
import com.hotel.request.BookingRequest;

public interface UserService {
    public User saveUser(User user);
    
    public User getUserById(Long userId);
    
    public User bookRoom(BookingRequest bookingRequest);
}

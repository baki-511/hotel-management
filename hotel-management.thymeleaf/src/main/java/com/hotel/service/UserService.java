package com.hotel.service;

import com.hotel.entity.Room;
import com.hotel.entity.RoomType;
import com.hotel.entity.User;
import com.hotel.request.BookingRequest;

import java.util.List;
import java.util.Set;

public interface UserService {
    public User saveUser(User user);
    
    public User getUserById(Long userId);
    
    public User bookRoom(BookingRequest bookingRequest);
   
}

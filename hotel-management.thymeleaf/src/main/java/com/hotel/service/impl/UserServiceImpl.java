package com.hotel.service.impl;

import com.hotel.entity.*;
import com.hotel.exception.RoomNotFoundException;
import com.hotel.exception.RoomTypeNotAvailable;
import com.hotel.exception.UserNotFoundException;
import com.hotel.repository.RoomRepository;
import com.hotel.repository.RoomTypeRepository;
import com.hotel.repository.UserRepository;
import com.hotel.request.BookingRequest;
import com.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoomRepository roomRepository;
    
    @Autowired
    private RoomTypeRepository roomTypeRepository;
    
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }
    
    @Override
    public User bookRoom(BookingRequest bookingRequest) {
        Optional<User> optionalUser = userRepository.findByEmail(bookingRequest.getEmail());
        User user = new User();
        user.setEmail(bookingRequest.getEmail());
        user.setMobileNumber(bookingRequest.getPhone());
        user.setFirstName(bookingRequest.getFirstName());
        user.setLastName(bookingRequest.getLastName());
  
        List<Booking> bookings;
        if (optionalUser.isPresent()) {
            User mainUser = optionalUser.get();
            bookings = mainUser.getBookings();
        } else{
            bookings = new ArrayList<>();
        }
        //Setting Booking Details
        Booking booking = new Booking();
        booking.setCheckInDate(bookingRequest.getCheckInDate());
        booking.setCheckOutDate(bookingRequest.getCheckOutDate());
        booking.setTotalPrice(bookingRequest.getTotalPrice());
        
        //Set the room Details
        RoomType roomType = roomTypeRepository.findById(bookingRequest.getRoomId())
                .orElseThrow(() -> new RoomTypeNotAvailable(bookingRequest.getRoomId()));
        Room room = roomRepository.findByRoomType(roomType)
                .stream()
                .filter(Room::isAvailable)
                .findAny()
                .orElseThrow(() -> new RoomNotFoundException("Sorry! Room Is NOT Available"));
        room.setAvailable(false);
        booking.setRoom(room);
        
        //Set Payment Details
        Payment payment = new Payment();
        payment.setPaymentMethod(bookingRequest.getPaymentMethod());
        payment.setAmount(bookingRequest.getTotalPrice());
        payment.setPaymentStatus("Success");
        booking.setPayment(payment);
        
        bookings.add(booking);
        user.setBookings(bookings);
        
        //Save Details In Databases
        return userRepository.save(user);
    }
    
    
    
    
}

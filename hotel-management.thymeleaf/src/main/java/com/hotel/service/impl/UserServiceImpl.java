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
        User user = new User();
        Optional<User> optionalUser = userRepository.findByEmail(bookingRequest.getEmail());
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        } else {
            user.setEmail(bookingRequest.getEmail());
        }
//        Customer Details
        Customer customer = new Customer();
        customer.setMobileNumber(bookingRequest.getPhone());
        customer.setFirstName(bookingRequest.getFirstName());
        customer.setLastName(bookingRequest.getLastName());
        customer.setUser(user);
        
        List<Customer> customers = user.getCustomers();
        if (customers == null) {
            customers = new ArrayList<>();
        }
        customers.add(customer);
        user.setCustomers(customers);
//        Add address to list
        List<Address> addressList = user.getAddressList();
        if (addressList == null) {
            addressList = new ArrayList<>();
        }
        Address address = new Address();
        address.setCity(bookingRequest.getCity());
        address.setState(bookingRequest.getState());
        address.setPincode(bookingRequest.getPincode());
        address.setUser(user);
        addressList.add(address);
//        Save address
        user.setAddressList(addressList);
        List<Booking> bookings;
        if (optionalUser.isPresent()) {
            User mainUser = optionalUser.get();
            bookings = mainUser.getBookings();
        } else {
            bookings = new ArrayList<>();
        }
        
//        Setting Booking Details
        Booking booking = new Booking();
        booking.setCheckInDate(bookingRequest.getCheckInDate());
        booking.setCheckOutDate(bookingRequest.getCheckOutDate());
        booking.setAdultCount(bookingRequest.getAdultCount());
        booking.setChildCount(bookingRequest.getChildCount());
        booking.setTotalPrice(bookingRequest.getTotalPrice());
        booking.setUser(user);
        
//        Set the room Details
        RoomType roomType = roomTypeRepository.findById(bookingRequest.getRoomId())
                .orElseThrow(() -> new RoomTypeNotAvailable(bookingRequest.getRoomId()));
//        Room
        Room room = roomRepository.findByRoomType(roomType).stream()
                .findAny()
                .orElseThrow(() -> new RoomNotFoundException("Sorry! Room Is NOT Available"));
//        room.setAvailable(false);
        booking.setRoom(room);
//        Set Payment Details
        Payment payment = new Payment();
        payment.setPaymentMethod(bookingRequest.getPaymentMethod());
        payment.setAmount(bookingRequest.getTotalPrice());
        payment.setPaymentStatus("Success");
        booking.setPayment(payment);
        payment.setBooking(booking);
        
        //set Person Details
        BookDetail detail = new BookDetail();
        detail.setFirstName(bookingRequest.getFirstName());
        detail.setLastName(bookingRequest.getLastName());
        detail.setEmail(bookingRequest.getEmail());
        detail.setMobileNumber(bookingRequest.getPhone());
        detail.setCity(bookingRequest.getCity());
        detail.setState(bookingRequest.getState());
        detail.setPincode(bookingRequest.getPincode());
        booking.setBookDetail(detail);
        
        detail.setBooking(booking);
        
//         Add Booking
        bookings.add(booking);
        user.setBookings(bookings);
//        Save Details In Databases
        return userRepository.save(user);
    }
   
}

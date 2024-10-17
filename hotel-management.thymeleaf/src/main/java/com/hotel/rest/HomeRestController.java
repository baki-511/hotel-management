package com.hotel.rest;

import com.hotel.entity.RoomType;
import com.hotel.exception.RoomTypeNotAvailable;
import com.hotel.repository.RoomTypeRepository;
import com.hotel.service.BookingService;
import com.hotel.service.RoomService;
import com.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class HomeRestController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private RoomService roomService;
    
    @Autowired
    private BookingService bookingService;
    
    @Autowired
    private RoomTypeRepository roomTypeRepository;
    
    @GetMapping("/type/all")
    public ResponseEntity<?> getAllRooms() {
        return new ResponseEntity<>(roomService.getRoomByType(), HttpStatus.OK);
    }
    
    @GetMapping("/check")
    public ResponseEntity<?> isRoomTypeAvailable() {
        RoomType roomType = roomTypeRepository.findById(1)
                .orElseThrow(() -> new RoomTypeNotAvailable("NOT Available"));
        return new ResponseEntity<>(roomService.isRoomAvailable(roomType), HttpStatus.OK);
    }
    
    @GetMapping("/getBook")
    public ResponseEntity<?> getOccupied(@RequestBody CheckDates checkDates) {
        return new ResponseEntity<>(bookingService.occupiedBookings(checkDates.getStart(), checkDates.getEnd()), HttpStatus.OK);
    }
    
    @GetMapping("/available")
    public ResponseEntity<?> getAllAvailableRooms(@RequestBody CheckDates checkDates) {
        return new ResponseEntity<>(roomService.getAllAvailableRooms(checkDates.getStart(), checkDates.getEnd()), HttpStatus.OK);
    }
    
}

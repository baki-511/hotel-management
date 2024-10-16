package com.hotel.rest;

import com.hotel.entity.RoomType;
import com.hotel.exception.RoomTypeNotAvailable;
import com.hotel.repository.RoomTypeRepository;
import com.hotel.service.RoomService;
import com.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private RoomService roomService;
    
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
    
}

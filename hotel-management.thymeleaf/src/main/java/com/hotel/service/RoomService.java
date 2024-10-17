package com.hotel.service;

import com.hotel.entity.Room;
import com.hotel.entity.RoomType;
import com.hotel.request.RoomDto;
import com.hotel.request.RoomReservation;
import com.hotel.request.RoomTypeDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface RoomService {
    public RoomType addRoomType(RoomTypeDto roomTypeDto, MultipartFile file) throws IOException;
    public Room addRoom(RoomDto roomDto);
    public List<Room> getAllRooms();
    public List<RoomType> getAllRoomTypes();
    public RoomType getRoomTypeById(Integer id);
    public List<RoomType> getAllAvailableRoomType(RoomReservation roomReservation);
    public List<RoomType> getRoomByType();
    public Boolean isRoomAvailable(RoomType roomType);
    
    public List<Room> getAllAvailableRooms(LocalDate start, LocalDate end);
    
}

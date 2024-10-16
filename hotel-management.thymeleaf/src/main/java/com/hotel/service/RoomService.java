package com.hotel.service;

import com.hotel.entity.Room;
import com.hotel.entity.RoomType;
import com.hotel.request.RoomDto;
import com.hotel.request.RoomTypeDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface RoomService {
    public RoomType addRoomType(RoomTypeDto roomTypeDto, MultipartFile file) throws IOException;
    
    public Room addRoom(RoomDto roomDto);
    public List<RoomType> getAllRoomTypes();
    
    public RoomType getRoomTypeById(Integer id);
    
}

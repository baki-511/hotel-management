package com.hotel.service.impl;

import com.hotel.entity.RoomType;
import com.hotel.repository.RoomTypeRepository;
import com.hotel.request.RoomTypeDto;
import com.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomTypeRepository roomTypeRepository;
    
    @Override
    public RoomType addRoom(RoomTypeDto roomTypeDto, MultipartFile file) throws IOException {
        RoomType roomType = new RoomType();
        roomType.setType(roomTypeDto.getRoomType());
        roomType.setCapacity(roomTypeDto.getCapacity());
        roomType.setPricePerNight(roomTypeDto.getPricePerNight());
        roomType.setDescription(roomTypeDto.getDescription());
        roomType.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        return roomTypeRepository.save(roomType);
    }
}

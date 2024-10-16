package com.hotel.service.impl;

import com.hotel.entity.RoomType;
import com.hotel.exception.RoomTypeNotAvailable;
import com.hotel.repository.RoomRepository;
import com.hotel.repository.RoomTypeRepository;
import com.hotel.service.RoomService;
import com.hotel.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {
    @Autowired
    private RoomTypeRepository roomTypeRepository;
    
    @Override
    public RoomType getRoomTypeById(Integer roomTypeId) {
        return roomTypeRepository.findById(roomTypeId)
                .orElseThrow(() -> new RoomTypeNotAvailable("Room Type NOT Available"));
    }
    
    @Override
    public List<RoomType> getAllRoomType() {
        return roomTypeRepository.findAll();
    }
}

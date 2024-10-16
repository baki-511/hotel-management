package com.hotel.service;

import com.hotel.entity.RoomType;

import java.util.List;

public interface RoomTypeService {
    public RoomType getRoomTypeById(Integer roomTypeId);
    
    public List<RoomType> getAllRoomType();
}

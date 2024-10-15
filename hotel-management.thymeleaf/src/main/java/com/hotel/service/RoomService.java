package com.hotel.service;

import com.hotel.entity.RoomType;
import com.hotel.request.RoomTypeDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface RoomService {
    public RoomType addRoom(RoomTypeDto roomTypeDto, MultipartFile file) throws IOException;
}

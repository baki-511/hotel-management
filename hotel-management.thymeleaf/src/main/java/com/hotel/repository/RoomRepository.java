package com.hotel.repository;

import com.hotel.entity.Room;
import com.hotel.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {
    public List<Room> findByRoomType(RoomType roomType);
}

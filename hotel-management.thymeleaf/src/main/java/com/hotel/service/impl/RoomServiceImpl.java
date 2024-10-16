package com.hotel.service.impl;

import com.hotel.entity.Room;
import com.hotel.entity.RoomType;
import com.hotel.exception.RoomTypeNotAvailable;
import com.hotel.repository.RoomRepository;
import com.hotel.repository.RoomTypeRepository;
import com.hotel.request.RoomDto;
import com.hotel.request.RoomReservation;
import com.hotel.request.RoomTypeDto;
import com.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomTypeRepository roomTypeRepository;
    
    @Autowired
    private RoomRepository roomRepository;
    
    @Override
    public RoomType addRoomType(RoomTypeDto roomTypeDto, MultipartFile file) throws IOException {
        RoomType roomType = new RoomType();
        roomType.setType(roomTypeDto.getRoomType());
        roomType.setCapacity(roomTypeDto.getCapacity());
        roomType.setPricePerNight(roomTypeDto.getPricePerNight());
        roomType.setDescription(roomTypeDto.getDescription());
        roomType.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        return roomTypeRepository.save(roomType);
    }
    
    @Override
    public Room addRoom(RoomDto roomDto) {
        Room room = new Room();
        room.setRoomNumber(roomDto.getRoomNumber());
        room.setAvailable(true);
        RoomType roomType = roomTypeRepository.findById(roomDto.getRoomId())
                .orElseThrow(() -> new RoomTypeNotAvailable(roomDto.getRoomId()));
        room.setRoomType(roomType);
        return roomRepository.save(room);
    }
    
    @Override
    public List<RoomType> getAllRoomTypes() {
        return roomTypeRepository.findAll();
    }
    
    @Override
    public RoomType getRoomTypeById(Integer id) {
        return roomTypeRepository.findById(id)
                .orElseThrow(() -> new RoomTypeNotAvailable("This Room Type Is NOT Available"));
    }
    
    @Override
    public List<RoomType> getAllAvailableRoomType(RoomReservation roomReservation) {
        List<Room> availableRooms = roomRepository.findByIsAvailableTrue().stream()
                .filter(f -> f.getRoomType().getCapacity() >= roomReservation.getAdultCount())
                .toList();
        LocalDate checkIn = roomReservation.getCheckInTime();
        LocalDate checkOut = roomReservation.getCheckoutTime();
        
        
        
        return null;
    }
    
    
    @Override
    public List<RoomType> getRoomByType() {
        return roomRepository.findAll().stream()
                .filter(Room::isAvailable)
                .map(Room::getRoomType)
                .distinct().collect(Collectors.toList());
    }
    
    @Override
    public Boolean isRoomAvailable(RoomType roomType) {
        List<Room> allRoomByType = findAllRoomByType(roomType);
        System.out.println((long) allRoomByType.size());
        return (long) allRoomByType.size() != 0;
    }
    
    private List<Room> findAllRoomByType(RoomType roomType) {
        return roomRepository
                .findAll().stream()
                .filter(Room::isAvailable)
                .filter(f -> f.getRoomType().equals(roomType))
                .collect(Collectors.toList());
    }
    
//    private List<Room> findAllRoom
}

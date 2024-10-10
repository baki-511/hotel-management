package com.hotel.exception;

public class RoomTypeNotAvailable extends RuntimeException {
    public RoomTypeNotAvailable(Integer roomTypeId) {
        super("Room NOT Available");
    }
    
    public RoomTypeNotAvailable(String msg) {
        super(msg);
    }
}

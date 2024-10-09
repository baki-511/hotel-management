package com.hotel.exception;

public class RoomNotFoundException extends RuntimeException{
    public RoomNotFoundException(Long roomId) {
        super("Room NOT Found with ID : " + roomId);
    }
    
    public RoomNotFoundException(String msg) {
        super(msg);
    }
}

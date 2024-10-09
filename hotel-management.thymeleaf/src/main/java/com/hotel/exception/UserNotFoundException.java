package com.hotel.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long userId) {
        super("User NOT Found with ID : " + userId);
    }
    
    public UserNotFoundException(String msg) {
        super(msg);
    }
}

package com.hotel.exception;

public class ReviewNotFoundException extends RuntimeException{
    public ReviewNotFoundException(Long reviewId) {
        super("Review NOT Found With ID : " + reviewId);
    }
    
    public ReviewNotFoundException(String msg) {
        super(msg);
    }
}

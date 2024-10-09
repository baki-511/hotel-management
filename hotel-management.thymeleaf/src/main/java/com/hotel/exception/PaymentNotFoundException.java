package com.hotel.exception;

public class PaymentNotFoundException extends RuntimeException{
    public PaymentNotFoundException(Long paymentId) {
        super("Payment NOT found with ID : " + paymentId);
    }
    
    public PaymentNotFoundException(String msg) {
        super(msg);
    }
}

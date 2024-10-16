package com.hotel.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingRequest {
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String state;
        private String city;
        private String pincode;
        private Integer roomId;
        private LocalDate checkInDate;
        private LocalDate checkOutDate;
        private String paymentMethod;
        private Double totalPrice;
}

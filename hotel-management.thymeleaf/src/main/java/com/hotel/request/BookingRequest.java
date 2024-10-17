package com.hotel.request;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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
        private Integer adultCount;
        private Integer childCount;
        private String paymentMethod;
        private Double totalPrice;
}

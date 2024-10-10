package com.hotel.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingRequest {
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private Integer roomId;
        private Date checkInDate;
        private Date checkOutDate;
        private String paymentMethod;
        private Double totalPrice;
}

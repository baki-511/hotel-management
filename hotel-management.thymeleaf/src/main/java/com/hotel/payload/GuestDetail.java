package com.hotel.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GuestDetail {
    private LocalDate checkIn;
    private LocalDate checkOut;
    private Integer totalGuest;
    private String roomType;
    private String roomNo;
}

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
public class RoomReservation {
    private LocalDate checkInTime;
    private LocalDate checkoutTime;
    private Integer adultCount;
    private Integer childCount;
}

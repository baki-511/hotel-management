package com.hotel.request;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RoomReservation {
    private Integer roomTypeId;
    private LocalDate checkInTime;
    private LocalDate checkOutTime;
    private Integer adultCount;
    private Integer childCount;
}

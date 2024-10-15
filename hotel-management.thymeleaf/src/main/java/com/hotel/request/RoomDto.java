package com.hotel.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoomDto {
    private String roomNumber;
    private String roomType;
    private Integer capacity;
    private Integer pricePerNight;
    private String description;
    private boolean isAvailable;
}

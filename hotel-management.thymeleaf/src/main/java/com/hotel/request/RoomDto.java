package com.hotel.request;

import com.hotel.entity.RoomType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RoomDto {
    private String roomNumber;
    private Integer roomId;
}

package com.hotel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomTypeId;
    private String type;
    private Integer capacity;
    private Integer pricePerNight;
    private String description;
    private String image;
    
    @OneToMany(mappedBy = "roomType", cascade = CascadeType.ALL)
    private List<Room> roomList;
}

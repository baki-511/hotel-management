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
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;
    private String roomNumber;
    private String type;
    private Integer capacity;
    private Integer pricePerNight;
    private boolean isAvailable;
    
    @OneToMany(mappedBy = "room")
    private List<Booking> bookings;
    
    @OneToMany(mappedBy = "room")
    public List<Review> reviews;
}

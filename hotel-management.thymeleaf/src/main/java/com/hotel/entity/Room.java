package com.hotel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

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
    private boolean isAvailable;
    
    @ManyToOne
    @JoinColumn(name = "room_type", nullable = true)
    private RoomType roomType;
    
    @OneToMany(mappedBy = "room")
    @JsonBackReference
    private List<Booking> bookings;
    
    @OneToMany(mappedBy = "room")
    public List<Review> reviews;
    
    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomNumber='" + roomNumber + '\'' +
                ", isAvailable=" + isAvailable +
                ", roomType=" + roomType +
                '}';
    }
}

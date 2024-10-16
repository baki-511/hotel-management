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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    
    private String password;
    
    @OneToMany(mappedBy = "user")
    private List<Address> addressList;
    
    @OneToMany(mappedBy = "user")
    private List<Booking> bookings;
    
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;
}

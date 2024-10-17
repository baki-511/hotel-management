package com.hotel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookDetailId;
    
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String state;
    private String city;
    private String pincode;
    
    @OneToOne
    private Booking booking;
}

package com.hotel.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDto {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;
    private String state;
    private String city;
    private String pincode;
    private String paymentMethod;
}

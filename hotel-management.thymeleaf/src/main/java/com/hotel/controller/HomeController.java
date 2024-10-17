package com.hotel.controller;

import com.hotel.entity.Booking;
import com.hotel.entity.RoomType;
import com.hotel.request.BookingRequest;
import com.hotel.request.CustomerDto;
import com.hotel.request.RoomReservation;
import com.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private RoomService roomService;
    
    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    @GetMapping("/about")
    public String aboutUs() {
        return "/pages/about_us";
    }
    
    @GetMapping("/services")
    public String services() {
        return "/pages/service";
    }
    
    @GetMapping("/gallery")
    public String gallery() {
        return "/pages/gallery";
    }
    
    @GetMapping("/rooms")
    public String rooms() {
        System.out.println("This is Normal Room");
        return "/pages/rooms";
    }
    
    
    @GetMapping("/checkout/{roomId}")
    public String checkout(
            @PathVariable Integer roomId,
            @Param("checkIn") LocalDate checkIn,
            @Param("checkOut") LocalDate checkOut,
            @Param("adultCount") Integer adultCount,
            @Param("childCount") Integer childCount,
            Model model
    ) {
        System.out.println(roomId + " " + checkIn + " " + checkOut + " " + adultCount + " " + childCount);
        System.out.println("Math " + (adultCount * 10));
        RoomType roomType = roomService.getRoomTypeById(roomId);
        
        RoomReservation reservation = new RoomReservation();
        reservation.setCheckInTime(checkIn);
        reservation.setCheckOutTime(checkOut);
        reservation.setAdultCount(adultCount);
        reservation.setChildCount(childCount);
        
        double gst = roomType.getPricePerNight() * 0.18;
        String formattedGST = String.format("%.2f", gst);
        
        double total = roomType.getPricePerNight() + gst;
        String formattedTotal = String.format("%.2f", total);
        
        model.addAttribute("typeId", roomId);
        model.addAttribute("roomType", roomType);
        model.addAttribute("reserve", reservation);
        model.addAttribute("gst", formattedGST);
        model.addAttribute("total", formattedTotal);
        return "/pages/checkout";
    }
    
    @GetMapping("/search-result")
    public String searchResult(@ModelAttribute RoomReservation roomReservation, Model model) {
//        System.out.println(roomReservation);
        List<RoomType> all = roomService.getAllRoomTypes();
        model.addAttribute("all", all);
        model.addAttribute("reserve", roomReservation);
        return "/pages/search-result";
    }
    
    @GetMapping("/checkout")
    public String checkout() {
        return "/pages/checkout";
    }
    
    
    @GetMapping("/contact-us")
    public String contactUs() {
        return "/pages/contact_us";
    }
    
    
    @GetMapping("/get-room-details")
    public String getRoomDetails(@ModelAttribute RoomReservation roomReservation, Model model) {
        System.out.println(roomReservation);
//        searchResult(roomReservation, model);
        return "redirect:/search-result";
    }
    
    @PostMapping("/success/{roomId}")
    public String success(
            @PathVariable Integer roomId,
            @Param("checkIn") LocalDate checkIn,
            @Param("checkOut") LocalDate checkOut,
            @Param("adultCount") Integer adultCount,
            @Param("childCount") Integer childCount,
            @ModelAttribute CustomerDto customerDto,
            Model model
    ) {
        BookingRequest request = new BookingRequest();
        request.setCheckInDate(checkIn);
        request.setCheckOutDate(checkOut);
        request.setAdultCount(adultCount);
        request.setChildCount(childCount);
        
        request.setFirstName(customerDto.getFirstName());
        request.setLastName(customerDto.getLastName());
        request.setEmail(customerDto.getEmail());
        request.setPhone(customerDto.getMobileNumber());
        request.setCity(customerDto.getCity());
        request.setState(customerDto.getState());
        request.setPincode(customerDto.getPincode());
        request.setPaymentMethod(customerDto.getPaymentMethod());
        
        RoomType roomType = roomService.getRoomTypeById(roomId);
        Integer roomPrice = roomType.getPricePerNight();
        double gst = roomPrice * 0.18;
        double totalPrice = 0.0;
        totalPrice = roomPrice + gst;
        String formattedPrice = String.format("%.2f", totalPrice);
        totalPrice = Double.parseDouble(formattedPrice);
        request.setTotalPrice(totalPrice);
        
        System.out.println(request);
        return "/pages/final-page";
    }
    
}

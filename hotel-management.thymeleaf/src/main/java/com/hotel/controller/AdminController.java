package com.hotel.controller;

import com.hotel.entity.RoomType;
import com.hotel.request.RoomTypeDto;
import com.hotel.service.RoomService;
import com.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private RoomService roomService;
    
    @GetMapping("/home")
    public String adminHome() {
        return "admin/pages/admin-idx";
    }
    
    @GetMapping("/create-room")
    public String roomBook(Model model) {
        model.addAttribute("room", new RoomTypeDto());
        return "admin/pages/add-room";
    }
    
    @PostMapping("/add-room")
    public String addRoom(@ModelAttribute RoomTypeDto roomTypeDto,
                          @RequestParam("imageFile") MultipartFile imageFile, Model model) throws IOException {
        roomService.addRoom(roomTypeDto, imageFile);
        return "redirect:/admin/create-room";
    }
}

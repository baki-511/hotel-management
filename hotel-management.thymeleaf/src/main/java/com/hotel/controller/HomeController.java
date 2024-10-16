package com.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
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
    
    @GetMapping("/contact-us")
    public String contactUs() {
        return "/pages/contact_us";
    }
}

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
    
    @GetMapping("/rooms")
    public String rooms() {
        return "/pages/rooms";
    }
    
    @GetMapping("/search-result")
    public String searchResult() {
        return "/pages/search-result";
    }
    
    
    @GetMapping("/contact-us")
    public String contactUs() {
        return "/pages/contact_us";
    }
}

package com.hotel;

import com.hotel.entity.AdminUser;
import com.hotel.entity.Room;
import com.hotel.entity.RoomType;
import com.hotel.repository.AdminUserRepository;
import com.hotel.repository.RoomRepository;
import com.hotel.repository.RoomTypeRepository;
import com.hotel.service.RoomService;
import com.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private RoomTypeRepository roomTypeRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private AdminUserRepository adminUserRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Application is Running..");
	}
	
	@Override
	public void run(String... args) throws Exception {
		AdminUser adminUser = new AdminUser();
		adminUser.setUsername("navin@gmail.com");
		adminUser.setFullName("Navin Sharma");
		adminUser.setPassword(passwordEncoder.encode("admin"));
		adminUser.setRole("ADMIN");
//		adminUserRepository.save(adminUser);
	}
}

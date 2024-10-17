package com.hotel;

import com.hotel.entity.Room;
import com.hotel.entity.RoomType;
import com.hotel.repository.RoomRepository;
import com.hotel.repository.RoomTypeRepository;
import com.hotel.service.RoomService;
import com.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private RoomTypeRepository roomTypeRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoomService roomService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Application is Running..");
	}
	
	@Override
	public void run(String... args) throws Exception {
		roomRepository.findAll()
				.forEach(r->{
					r.setAvailable(true);
//					roomRepository.save(r);
				});
	}
}

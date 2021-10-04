package com.sandino.spring.roomreservationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class RoomReservationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomReservationServiceApplication.class, args);
	}

}

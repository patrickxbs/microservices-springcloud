package com.patrick.booking_service;

import com.patrick.booking_service.dto.BookingRequest;
import com.patrick.booking_service.service.BookingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class BookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BookingService service) {
		return args -> {
			BookingRequest request = new BookingRequest(UUID.fromString("7c02be27-42cd-4671-b648-2a5cf9bd61f2"), LocalDate.now(), LocalDate.now(), 2);
			service.makeBooking(UUID.fromString("7c02be27-42cd-4671-b648-2a5cf9bd61f1"), request);
		};
	}
}
